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
	["300", "user_1", "resource_3"],
	["599", "user_1", "resource_3"],
	["900", "user_1", "resource_3"],
	["1199", "user_1", "resource_3"],
	["1200", "user_1", "resource_3"],
	["1201", "user_1", "resource_3"],
	["1202", "user_1", "resource_3"]

]

function findTimeRange(logs1) {
	const resourceToTimeMap = {}
	for (let log of logs1) {
		const resName = log[2];
		if (!resourceToTimeMap[resName]) {
			resourceToTimeMap[resName] = [];
		}
		resourceToTimeMap[resName].push(Number(log[0]));
	}

	let maxRes = 0;
	let resNam = "";
	for (let key of Object.keys(resourceToTimeMap)) {
		const resAccessList = resourceToTimeMap[key];
		const resUsage = getUtilisationForResource(resAccessList.sort((a, b) => a - b))
    console.log(" res name ", key, " usage ", resUsage)
		if (resUsage > maxRes) {
			resNam = key;
      maxRes = resUsage;
		}
	}

	console.log("resNam ", resNam, " maxRes ", maxRes);
}

function getUtilisationForResource(timingList) {
	let l = 0, r = 1;
	let max = 0;
	console.log("processing => ", timingList)
	let maxArr = []
	let tempMax;
	while (r < timingList.length) {
		if (timingList[r] - timingList[l] <= 300) {
			maxArr = timingList.slice(l, r + 1)
			r++;
			if ((r - l)> max) max = (r - l) ;

		} else {
			tempMax = timingList.slice(l, r);
			l++;
			maxArr = [];
		}

	}
	console.log("max ", max, " arr ", maxArr, "\ntempMax ", tempMax)
	return max
}

findTimeRange(logs1)