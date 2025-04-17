// Step1. 이벤트 줄 요소 선택하기
let tabBtns = document.querySelectorAll("#tab .tab_btns button");
let tabContents = document.querySelectorAll("#tab .contents .all");
let tabContentsBox = document.querySelector("#tab .contents");

// Step2. 이벤트 등록하기
for (let i = 0; i < tabBtns.length; i++) {
  tabBtns[i].addEventListener("click", showTabContents);
  tabBtns[i].addEventListener("click", changeColor);
}

// changeColor(tabBtns[0]);
// showTabContents("all");
// 클릭한 카테고리에 해당하는
// 관련 컨텐츠 모두 보이게하기
// Step3. 함수 선언하기
function showTabContents() {
  // Step4. 함수 구현하기
  //this : 이벤트가 발생한 객체
  //
  let contentClassName = this.id;
  console.log(contentClassName);

  //컨텐츠의 클래스값 -> 선택하여 display: block;
  for (let i = 0; i < tabContents.length; i++) {
    tabContents[i].style.display = "none";
    // tabContents[i].classList.remove("active");
  }

  let activeContents = document.querySelectorAll("." + contentClassName);

  for (let i = 0; i < activeContents.length; i++) {
    activeContents[i].style.display = "block";
    // activeContents[i].classList.add("active");
  }
  // tabContentsBox.style.height = activeContents[0].offsetHeight + 'px';
}

function changeColor() {
  for (let i = 0; i < tabBtns.length; i++) {
    tabBtns[i].style.backgroundColor = "white";
    tabBtns[i].style.color = "black";
  }
  this.style.backgroundColor = "black";
  this.style.color = "white";
}
