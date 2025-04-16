// Step1. 요소 선택하기
let btns = document.querySelectorAll('label');
console.log(btns);
let slides = document.querySelectorAll('li');

// Step2. 이벤트 할당하기
for(let i = 0; i < btns.length; i++){
  btns[i].addEventListener('click',sliding);
  btns[i].addEventListener('click',changeColor);
}

let index = 0;

function sliding(){
  index = parseInt(this.id.charAt(this.id.length-1));
  console.log(index);

  slides.forEach(function(slide){
    slide.style.transform = `translateX(${index*(-100)}%)`;
  });
}

function changeColor(){
  btns.forEach(function(btn){
    btn.classList.remove('active');
  });
  this.classList.add('active');
}

// 클릭한 버튼의 배경색상 바꾸는 부분 추가
// js에 추가된 부분 확인 후, css파일에서 .active 선택 후 background-color 값 바꿔주면 됩니다
// .active 우선순위가 낮은 경우 조합선택자를 더 늘려보기