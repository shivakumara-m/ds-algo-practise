
const contentMap = {}

const maxScoreMap = {
    score: 100,
    contentId: 13,
}

const SortedSet = new SortedSet();
function incrScore(contentId, scoreToIncrease) {
    if (!contentMap[contentId]) {
        contentMap[contentId] = 0;
    }
    const finalScore = contentMap[contentId] + scoreToIncrease;
    contentMap[contentId] = finalScore;
    if(finalScore > maxScoreMap.score) {
        maxScoreMap.contentId = contentId;
        maxScoreMap.score = finalScore;
    }
}

function decScore(contentId, scoreToIncrease ) {
    if (!contentMap[contentId]) {
        contentMap[contentId] = 0;
    }
    const finalScore = contentMap[contentId] - scoreToIncrease;
    if(finalScore <= 0) {
        return
    }
    contentMap[contentId] = finalScore;
}

function incrScoreSet(contentId, scoreToIncrease) {
    const contentToIncr =  SortedSet.find(contentId); // log(N): { contetId:124, score:124}
    const finalScore = contentMap[contentId] + scoreToIncrease;
    contentToIncr.score = finalScore;
    SortedSet.remove(contentToIncr); // log(N)
    SortedSet.insert(contentToIncr); // log(N)
}

function decrScoreSet(contentId, scoreToIncrease) {
    const contentToIncr =  SortedSet.find(contentId); // log(N)
    const finalScore = Math.min(0, contentMap[contentId] - scoreToIncrease)
    contentToIncr.score = finalScore;
    SortedSet.remove(contentToIncr); // log(N)
    SortedSet.insert(contentToIncr);  // log(N)
}

function getMaxScoreItem() {
    SortedSet.getFirstItem(); 
}
