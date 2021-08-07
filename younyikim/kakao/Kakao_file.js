function solution(files) {
    // javascript의 sort() 메서드는 안정적이지 않기(순서를 보장하지 않기) 때문에 재정의가 필요.
    return files.sort((a, b) => {

        // 1. HEAD 를 기준으로 대소문자 구분 없이 사전식 정렬
        // HEAD가 같다면(0이라면), Number를 기준으로 정렬
        const reg = /^\D+/; // 모든 문자에 대응
        let headerA = a.match(reg)[0].toLowerCase();
        let headerB = b.match(reg)[0].toLowerCase();

        if(headerA > headerB) {
            return 1;
        }

        if(headerA < headerB) {
            return -1;
        }

        // 2. Number로 정렬(앞의 0은 생략한다.)
        const regNum = /\d+/; // 모든 숫자에 대응
        const regZero = /^0+/; // 0이 1회이상 반복되는 경우
        let numberA = a.match(regNum)[0].replace(regZero, "");
        let numberB = b.match(regNum)[0].replace(regZero, "");

        return numberA - numberB;
    });
}

const arr = ["img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"];
let result = solution(arr);
console.log(result);