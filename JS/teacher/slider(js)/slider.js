// Step 1 Selector
// 좌우 이미지에 클래스 .left 와 .right를 먼저 할당한다
let left = document.querySelector(".left");
let right = document.querySelector(".right");
console.log(left);
console.log(right);

let lis = document.querySelectorAll('#sliders li');
console.log(lis);

// Step 2 이벤트 할당
left.addEventListener("click", leftsliding);
right.addEventListener("click", rightsliding);

//전역변수 선언
let index = 0;
// Step 3 함수선언
//
//1번째 : translateX(0%); 0 * -100
//2번째 : translateX(-100%); 1* -100
//3번째 : translateX(-200%); 2* -100
function leftsliding() {
    index--;
    // 음수값이되면 안되므로 li의 갯수 값을 넣어줌 현재는 2
    console.log(lis.length);
    if (index < 0) {
        index = (lis.length - 1); //2을 입력
    }
    console.log("왼쪽 슬라이딩함수");
    console.log(index);
    lis.forEach(function (slide) {
        //li태그.style.transform = translateX()
        slide.style.transform = `translateX(${index * (-100)}%)`;
    });  
}
function rightsliding() {
    index++;
    // 마지막 슬라이더 번호보다 크면 안됨
    if (index >= (lis.length)) {
        index = 0; 
    }
    console.log("오른쪽 슬라이딩함수");
    console.log(index);
    lis.forEach(function (slide) {
        //li태그.style.transform = translateX()
        slide.style.transform = `translateX(${index * (-100)}%)`;
    }); 
}
