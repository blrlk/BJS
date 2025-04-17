// Step1. 이벤트 줄 요소 선택하기
let imgs = document.querySelectorAll("#tab .imgbox img");
let closeBtn = document.querySelector("#modal .close");

let modal = document.querySelector("#modal");
let modalImg = document.querySelector("#modalImg");

// Step2. 이벤트 등록하기
imgs.forEach(
  function(img){
    img.addEventListener("click", showModal);
  }
);
closeBtn.addEventListener("click", closeModal);

// Step3. 함수 선언하기
function showModal(){
  // Step4. 함수 구현하기
  /*
  최종 기능 : 내가 클릭한 이미지의 경로를 
  모달창 내부 이미지 경로로 수정하기
  1) 내가 클릭한 이미지의 경로값 가져와서
  2) 모달창 내부 이미지 경로에 대입하기
  */
  console.log(this);
  modalImg.src = this.src;
  modal.style.display = "block";
}

// Step3. 함수 선언하기
function closeModal(){
  // Step4. 함수 구현하기
  // x버튼 클릭할 경우 모달창 display:none;
  modal.style.display = "none";
}

// 검은배경 모달과 컨텐츠를 구분해야함
// this나 modal의 display:none을 해버리면 어디를 선택하든 꺼짐
// e : event객체
// e.target : event가 실제 발생한 요소
// this : event 핸들러가 등록된 요소
window.addEventListener("click", function(e){
  //e.target이 modal인 경우 none;
  //e.target이 modal_content일 경우 적용X
  if(e.target === modal){
    modal.style.display = "none";
  }
})