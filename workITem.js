class WorkItem {
    constructor(id, project, type, timestamp) {
        this.id = id;
        this.project = project;
        this.type = type;
        this.timestamp = timestamp;
    }

}

class QueryWorkItem {

    constructor(id, project, type, condition) {

        this.queryFields = {
            id : id,
            project : project,
            type : type
        }
        condition = condition
    }
}


function queryWorkItems(queryObj, workItems) {
    let resultList = [];

    for (let item of workItems) {
        // Get all the keys in the query obj:
        const condition = queryObj.condition; // AND / OR { id:1}
        console.log(" Query condition is ", condition)
        let isMatchedITem = false;
        switch (condition) {
            case "OR": 
                isMatchedITem = queryWithOR(queryObj, item);
            break;
            default:
                throw new Error("Not implemented");
        }

        if (isMatchedITem) {
            resultList.push(item);
        }

    }
    return resultList
}


function queryWithOR(queryObj, item) {
    console.log(" Inside query with OR")
    console.log(" My query object ", queryObj);
    console.log(" Item under search ", item)
    const queryFields = Object.keys(queryObj);
    for (let field of queryFields) {
        if (field != "condition" && queryObj[field] && (queryObj[field] == item[field])) {
            return true;
        }
    }
}

function queryWithAnd() { }


function testSearch() {
   
    const item1 = new WorkItem(1, "p1", "t1", 100);
    const item3 = new WorkItem(3, "p3", "t3", 10);
    const item2 = new WorkItem(2, "p2", "t2", 200);
    const workItemList = [item1, item3 ,item2];

    console.log("\n\UnSorted list", workItemList);

    const soretedList = workItemList.sort( (a, b) => {
        return a.timestamp - b.timestamp;
    })

    console.log("\n\Sorted list", soretedList);

    // const query1 = new QueryWorkItem(2, undefined, undefined, "OR");

    // const queryResults = queryWorkItems(query1, workItemList);
    
    // //assert here:
    // console.log("\n\nResults for query1 ", queryResults);

}

testSearch();



testSearch.before() 

testSe