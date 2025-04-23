let btns = document.querySelectorAll("#main .btns button");
let slides = document.querySelectorAll("#main .slide");


btns.forEach(function(btn){
  btn.addEventListener("click", sliding);
  btn.addEventListener("click", changeColor);
})

let index = 0;

function sliding(){
  index = this.id.charAt(1);
  console.log(index);

  slides.forEach(function(slide){
    slide.style.transform = `translateX(${index * (-100)}%)`;
  }); 
}

function changeColor(){
  btns.forEach(function(btn){
    btn.classList.remove("active");
  })

  this.classList.add("active");
}
