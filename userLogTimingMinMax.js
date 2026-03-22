logs1 = [
["58523", "user_1", "resource_1"],
["62314", "user_2", "resource_2"],
["54001", "user_1", "resource_3"],
["200", "user_6", "resource_5"],
["215", "user_6", "resource_4"],
["54060", "user_2", "resource_3"],
["53760", "user_3", "resource_3"],
["58522", "user_22", "resource_1"],
["53651", "user_5", "resource_3"],
["2", "user_6", "resource_1"],
["100", "user_6", "resource_6"],
["400", "user_7", "resource_2"],
["100", "user_8", "resource_6"],
["54359", "user_1", "resource_3"],
]

function findTimeRange(logs1) {
  const userLogMap = {};
  for(log of logs1) {
    const currentLogTime = Number(log[0]);
    const usrName = log[1];
    if(!userLogMap[usrName]) {
      userLogMap[usrName] = [currentLogTime, currentLogTime]
    }
    
    const usrMap = userLogMap[usrName];
    if(currentLogTime <= usrMap[0])  {
      usrMap[0] = currentLogTime;
    } else if(currentLogTime > usrMap[1]) {
       usrMap[1] = currentLogTime;
    }
      
    
  }
  console.log(userLogMap)
}

findTimeRange(logs1)