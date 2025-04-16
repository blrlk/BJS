// Step1. 요소 선택하기
let tabs = document.querySelectorAll('.tab');
let contents = document.querySelectorAll('.tab-content');

// Step2. 이벤트 할당하기
for (let i = 0; i < tabs.length; i++) {
  tabs[i].addEventListener('click', tabIdCalculator);
}

// Step3. 함수 선언하기
// Step4. 함수 기능 정의하기
/*
최종 목적 :
 탭메뉴버튼 클릭하면,
 1. 클릭한 탭메뉴 배경 색상 바꾸기
 2. 클릭한 탭메뉴(this)에 해당하는 컨텐츠 나타내기
  2.1 클릭한 탭메뉴(this)와 해당 컨텐츠의 접점 만들기
  2.2 접점 활용하여 컨텐츠 나타내기, 그외 숨김
*/

/* 
 탭버튼을 클릭한 this의 id를 가져와서
 관련된 탭컨텐츠를 선택하기 위한
 id문자열을 만드는 작업
 */
function tabIdCalculator() {
  let tabId = 'content-' + this.id;
  //tabId 예상 결과 : content-tab1 / content-tab2 / content-tab3

  activateTab(this);   
  showTabContent(tabId); 
}

//클릭 이벤트가 발생한 본인(this)의 배경색깔 바꾸기
function activateTab(tab) { 
  for (let i = 0; i < tabs.length; i++) {
    tabs[i].classList.remove('active');
  }
  tab.classList.add('active');
}

//클릭 이벤트가 발생한 버튼과 관련된 콘텐츠 나타내기
//this와의 관련성 : 교집합 만들어주기
function showTabContent(tabId) {
  //tabId : content-tab1, content-tab2, content-tab3
  for (let i = 0; i < contents.length; i++) {
    contents[i].classList.remove('active');
    // contents[i].style.display = "none";
  }

  let activeContent = document.querySelector("#" + tabId);
  if (activeContent) {
    activeContent.classList.add('active');
    // activeContent.style.display = "none";
  }
}
