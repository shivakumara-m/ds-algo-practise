var express = require('express');
var router = express.Router();
const RateLimiter = require('../controller');

const rateLimiter = new RateLimiter(1, 1000*10); // 1 request per 10 seconds


let ctr = 0;

router.get('/:userId', function(req, res, next) {
  console.log("request received for userId:", req.params.userId);
    const isAllowed = rateLimiter.rateLimitTokenBucket(req.params.userId);
    if(!isAllowed) {
      res.status(429).send('Rate limit exceeded. Try again later.' + new Date().toLocaleTimeString());
    }
    res.send('Request successful ' + new Date().toLocaleTimeString());
});


module.exports = router;
