function solution(msg) {
    const dict = {};
    let answer = [];

    // 사전 만들기
    for (let i = 1; i <= 26; i++) {
        dict[String.fromCharCode(i + 64)] = i;
    }

    let idx = 0;
    let dictLength = 26;
    let msgLength = msg.length;

    while (idx < msgLength) {
        let maxString = "";

        for (let i = idx; i < msgLength; i++) {
            const target = msg.substring(idx, i + 1);

            if (dict[target]) {
                maxString = target;
            } else {
                dict[target] = ++dictLength;
                break;
            }
        }

        answer.push(dict[maxString]);
        idx += maxString.length;
    }

    return answer;
}

let ans = solution("TOBEORNOTTOBEORTOBEORNOT");
console.log(ans);