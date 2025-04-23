let btns = document.querySelectorAll('.btn');
console.log(btns);
let slides_btn = document.querySelectorAll(".slide_btn");
// let slidebox_btn = document.querySelector(".slidebox_btn");

btns.forEach(function(btn){
  btn.addEventListener("click", sliding_btn);
  btn.addEventListener("click", changebtnColor);
})

let index_btn = 0;

function sliding_btn(){
  // 클릭된 버튼의 id 속성에서 마지막 글자를 가져와서 숫자로 변환
  index_btn = parseInt(this.id.charAt(this.id.length-1));
  console.log(index_btn);

  slides_btn.forEach(function(slide){
    slide.style.transform = `translateX(${index_btn*(-100)}%)`;
  });
}

function changebtnColor(){
  btns.forEach(function(btn){
    btn.classList.remove("active");
  });

  this.classList.add("active");
}