function solution(lines) {
    const times = [];

    for (const line of lines) {
        const [date, finish, duration] = line.split(' ');
        const millisecond = transTimeToMiliSecond(finish);
        const startTime = millisecond - duration.substr(0, duration.length - 1) * 1000 + 1;
        const endTime = millisecond + 999;
        /* 문제 조건에 의해 종료시간은 finish + 1이다. 
        1초는 1000ms 이지만, 앞서 시작시간에 1을 더해주었기 때문에 999를 더해주어야 한다.*/

        times.push(['START', startTime]);
        times.push(['END', endTime]);
    }

    // 시작시간을 기준으로 오름차순 정렬
    // 시작시간과 종료시간이 동일한 경우, -1을 반환해 두개의 순서를 바꿔 시작시간이 앞에 오게 한다.
    times.sort((a, b) => a[1] !== b[1] ? a[1] - b[1] : -1);
    console.log(times)

    let answer = 0;
    let count = 0;

    /*
    * 정렬된 times 배열을 순회하면서 'START'인 경우 카운트를 증가시키고,
    * 'END'인 경우 카운트를 감소 시키면서 초당 최대 처리량을 계산한다.
    */
    for (const time of times) {
        if (time[0] === 'START') count++;
        else count--;

        answer = Math.max(answer, count);
    }
    console.log(answer)
    // return answer;
}

const transTimeToMiliSecond = (time) => {
    // 시, 분, 초를 각각 sec로 변환한 뒤, 1000을 곱해 ms로 변환한다.
    const hour = (time[0] * 10 + time[1] * 1) * 60 * 60;
    const minute = (time[3] * 10 + time[4] * 1) * 60;
    const second = time[6] * 10 + time[7] * 1;
    const millis = time[9] * 100 + time[10] * 10 + time[11] * 1;
    const amount = (hour + minute + second) * 1000 + millis;

    return amount;
}

solution([
    "2016-09-15 20:59:57.421 0.351s",
    "2016-09-15 20:59:58.233 1.181s",
    "2016-09-15 20:59:58.299 0.8s",
    "2016-09-15 20:59:58.688 1.041s",
    "2016-09-15 20:59:59.591 1.412s",
    "2016-09-15 21:00:00.464 1.466s",
    "2016-09-15 21:00:00.741 1.581s",
    "2016-09-15 21:00:00.748 2.31s",
    "2016-09-15 21:00:00.966 0.381s",
    "2016-09-15 21:00:02.066 2.62s"
]);