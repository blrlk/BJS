//Step1. 이벤트 줄 요소 선택하기
//브라우저의 스크롤 : window
let headerTop = document.querySelector(".h_top");
let headerBottom = document.querySelector(".h_bottom");
let offset = headerTop.offsetHeight; // header_top의 높이
console.log(offset);

//Step2. 이벤트 할당하기
//Step3. 함수 선언하기 -> 무명함수로 대체
//Step4. 함수 구현하기
/*
최종 목적 :
heaerTop높이를 지나서 스크롤할 경우,
headerBottom 속성값을 바꿀 예정
  1) position:absolute -> position : fixed
  2) top : 100% -> top: 0
  3) background-color: transparent 
  -> backgroundColor: white
위 내용을 포함하는 클래스값을 부여하거나 제거.
*/

/*
header .h_bottom {
  width: 100%;
  position: absolute;
  top: 100%;
  left: 0;
  z-index: 22;
}

.h_bottom.scrolled {
  position: fixed;
  top: 0;
  background-color: white;
}
*/
window.addEventListener("scroll", function () {
  if (window.scrollY > offset) {
    headerBottom.classList.add("scrolled");
  } else {
    headerBottom.classList.remove("scrolled");
  }
});
