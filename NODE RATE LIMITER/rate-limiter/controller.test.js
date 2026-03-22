const RateLimiter = require('./controller');
const test = require('ava');

test('RateLimiter allows only a limited number of requests for the time window', t => {
    //given
    const rateLimiter = new RateLimiter(3, 1000); // 3 requests per second
    const customerId = 'user1';

    //when
    t.true(rateLimiter.rateLimit(customerId));
    t.true(rateLimiter.rateLimit(customerId));
    t.true(rateLimiter.rateLimit(customerId));

    //then
    t.true(rateLimiter.rateLimit(customerId) === false);
})

test('RateLimiter allows requests after the time window is reset', async t => {
    //given
    const rateLimiter = new RateLimiter(3, 1000); // 3 requests per second
    const customerId = 'user2';
    t.true(rateLimiter.rateLimit(customerId));
    t.true(rateLimiter.rateLimit(customerId));
    t.true(rateLimiter.rateLimit(customerId));
    t.true(rateLimiter.rateLimit(customerId) === false);

    //when
    //await Promise.resolve(resolve => setTimeout(() => {}, 1000 * 3)); // wait for more than the duration to reset the window
    console.log("wiating for 4.1 seconds ");
    //then

    await new Promise(resolve => setTimeout(function() { resolve(); }, 4100) );
    console.log("waited for 4.1 seconds ");    
    t.true(rateLimiter.rateLimit(customerId));
    t.true(rateLimiter.rateLimit(customerId));
    t.true(rateLimiter.rateLimit(customerId));
})