// Step1. 요소 선택하기
let tabs = document.querySelectorAll('.tab');
let contents = document.querySelectorAll('.tab-content');

// Step2. 이벤트 할당하기
for (let i = 0; i < tabs.length; i++) {
  tabs[i].addEventListener('click', showTabContent);
  tabs[i].addEventListener('click', activateTab);
}

/*
Step3. 함수 선언하기
Step4. 함수 구현하기 : 클릭한 메뉴와 관련된 컨텐츠 나타내기(block)
 1) 클릭한 메뉴는 this이고
 2) this와 관련된 컨텐츠 선택하여 나타내기
 2-1) this.id값과 같은 class값을 가진 요소 선택하여 변수에 담기(짝궁) 
 2-2) "모든" 컨텐츠의 style.display = "none"; 처리
 2-3) this와 관련된 컨텐츠만 style.display = "block"; 처리
*/
function showTabContent() {
  let tabClass = this.id; //가능한 값 tab1 / tab2 / tab3

  for (let i = 0; i < contents.length; i++) {
    contents[i].style.display = "none";
  }

  let activeContent = document.querySelector("." + tabClass);
  if (activeContent) {
    activeContent.style.display = "block";
  }
}

/*
Step3. 함수 선언하기
Step4. 함수 구현하기 : 클릭한 메뉴 본인(this)의 배경색상 바꾸기
 1) "모든" 탭메뉴의 style.backgroundColor = "지정하려는 기본색상";
 2) 클릭한 본인(this)의 style.backgroundColor = "기본색상과 차이나는 색상";
*/
function activateTab() { 
  for (let i = 0; i < tabs.length; i++) {
    tabs[i].style.backgroundColor = "#f1f1f1";
  }
  this.style.backgroundColor = "#ccc";
}
