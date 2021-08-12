function solution(n, t, m, p) {
    let answer = '';
    let binaryNumber = '';
    let tmp = 0;
    let arr = [];

    for (let i = 0; i < t * m; i++) {
        tmp = i.toString(n);
        binaryNumber += tmp.toUpperCase();
    }
    arr = binaryNumber.split("");

    for (let i = p - 1; i < arr.length; i += m) {
        answer += arr[i];
    }
    answer = answer.substring(0, t);
    return answer;
}

solution(16, 16, 2, 1);
// solution(2, 4, 2, 1);