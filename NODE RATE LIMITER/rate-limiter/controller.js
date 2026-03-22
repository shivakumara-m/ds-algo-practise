
const moment = require('moment')

class RateLimiter {

    constructor(windowSize, duration) {
        this.userRequests = {};
        this.windowSize = windowSize;
        this.duration = duration;
        this.tokenMap = {};
        this.maxTokensPerUser = 10;
        this.refillIntervalInMillis = 1;
        this.fillRate=1; // 1 token per millisecond
    }

    rateLimit(customerId) {

        const activeRequests = this.userRequests[customerId]|| [];
        console.log("activeRequests: customerId ", activeRequests, customerId);
        console.log("HH:MM:SS ", new Date().toLocaleTimeString());

        this.resetWindow(customerId);
        if(activeRequests.length >= this.windowSize) { 
            const logObj = {
                customerId: customerId,
                message: 'Rate limit exceeded, user has more active requests than allowed',
            }
            console.log(logObj)
            return false;
        }

        activeRequests.push(Date.now());
        this.userRequests[customerId] = activeRequests;
        return true;
    
    }

    resetWindow(customerId) {
        const activeRequests = this.userRequests[customerId]|| [];
        console.log("Before reset activeRequests: customerId ", activeRequests, customerId);
        if(activeRequests.length === 0) return;
        let windowStart = activeRequests[0];
        const currentTime = Date.now();
        while (activeRequests.length > 0 && (currentTime - windowStart) > this.duration) {
            activeRequests.shift();
            windowStart = activeRequests[0];
        }
    }

    rateLimitTokenBucket(customerId) {
        const currentTime = moment.now();
        if(!this.tokenMap[customerId]) {
            this.tokenMap[customerId] = {
                tokens: this.maxTokens,
                lastRefill: moment.now()
            }
        }
        const userBucket = this.tokenMap[customerId];
        this.resetBucket(currentTime, userBucket); 
        if(this.tokenMap[customerId].tokens <= 0) {
            return false
        }
        userBucket.tokens -= 1;
        return true;

    }

    resetBucket(currentTime, userBucket) {
        const timeFromLastFill = currentTime - userBucket.lastRefill;
        if(timeFromLastFill < this.refillIntervalInMillis) return;
        
        const timeSinceLastRefill = currentTime - userBucket.lastRefill;
        const tokensToAdd =  (timeSinceLastRefill / this.refillIntervalInMillis) * this.fillRate;   
        userBucket.lastRefill = currentTime;
        userBucket.tokens = Math.min(this.maxTokensPerUser, userBucket.tokens+tokensToAdd);
    }
}

module.exports = RateLimiter;