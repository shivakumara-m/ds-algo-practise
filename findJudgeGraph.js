
var findJudge = function (n, trust) {
    const mp = {};
    const outTrust = {}
    const inTrust = {}

    if(n ==1) return 1

    for (let p of trust) {
        
        if(!outTrust[p[0]]) {
            outTrust[p[0]]= 0
        }

          if(!inTrust[p[1]]) {
            inTrust[p[1]]= 0
        }

        outTrust[p[0]] +=1
        inTrust[p[1]] +=1
    }
    console.log(" out ", outTrust , "\n in ", inTrust)
    for (let i = 1; i <= n; i++) {
        if(inTrust[i]==n-1 && !outTrust[i]) return i;
    }
    return -1
};