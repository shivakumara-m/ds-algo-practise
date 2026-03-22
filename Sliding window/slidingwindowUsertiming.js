"use strict";

console.log('Hello, world!');
console.log('This is a fully functioning JavaScript environment.');

function findLogins() {
	const badge_times = [
		["Paul", "1355"], ["Jennifer", "1910"], ["Jose", "835"],
		["Jose", "830"], ["Paul", "1315"], ["Chloe", "0"],
		["Chloe", "1910"], ["Jose", "1615"], ["Jose", "1640"],
		["Paul", "1405"], ["Jose", "855"], ["Jose", "930"],
		["Jose", "915"], ["Jose", "730"], ["Jose", "940"],
		["Jennifer", "1335"], ["Jennifer", "730"], ["Jose", "1630"],
		["Jennifer", "5"], ["Chloe", "1909"], ["Zhang", "1"],
		["Zhang", "10"], ["Zhang", "109"], ["Zhang", "110"],
		["Amos", "1"], ["Amos", "2"], ["Amos", "400"],
		["Amos", "500"], ["Amos", "503"], ["Amos", "504"],
		["Amos", "601"], ["Amos", "602"], ["Paul", "1416"],
	];
	const userTimingMap = {}
	for (let usertime of badge_times) {
		if (!userTimingMap[usertime[0]]) {
			userTimingMap[usertime[0]] = []
		}
		let userTime = addPaddingIfNotPresent(usertime[1]);

		userTimingMap[usertime[0]].push(userTime)
	}
	for (let key of Object.keys(userTimingMap)) {
    	console.log("\n\nUnsortedTimingForUser ", key, " ",  userTimingMap[key])
		const sortedTimingForUser = userTimingMap[key].sort((a, b) => Number(a) - Number(b));
		console.log("sortedTimingForUser ", key, " ", sortedTimingForUser)
		const windowForUser = getMaxRepeatWindow(sortedTimingForUser)
		console.log("Window for user ", key, ": ", windowForUser);
	}

}

function addPaddingIfNotPresent(timing) {
	const len = timing.length;
	const diff = 4 - len;
	if (diff == 0) return timing;
	else if (diff == 1) return "0" + timing;
	else if (diff == 2) return "00" + timing;
	else if (diff == 3) return "000" + timing;
}

function getMaxRepeatWindow(sortedTime) {
	let window = [];
	let l = 0; let r = 0;
	while (l <= r && r < sortedTime.length) {
		const diff = Number(sortedTime[r]) - sortedTime[l];
		if (diff <= 100) {
			window.push(sortedTime[r]);
			if (window.length >= 3) {
				return window;
			}
			r++;
		} else {
			l++;
      window = sortedTime.slice(l, r+1);

		}

	}
	return []
}

findLogins();