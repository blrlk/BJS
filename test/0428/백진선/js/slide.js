

// slide
let left = document.querySelector("i.left");
let right = document.querySelector("i.right");
let slides = document.querySelectorAll(".slide");
let slidebox = document.querySelector(".slides");

let firstcontent = slides[0].cloneNode(true);
let lastcontent = slides[slides.length - 1].cloneNode(true);
slidebox.appendChild(firstcontent);
slidebox.insertBefore(lastcontent, slides[0]);
slides = document.querySelectorAll(".slide");

left.addEventListener("click", leftSliding);
right.addEventListener("click", rightSliding);

setInterval(() => {
  rightSliding();
}, 2500);

let index = 1;
sliding(false);

function leftSliding(){
  index--;
  if(index <= 0){
    sliding(true);
    index = slides.length - 2;

    setTimeout(() => {
      sliding(false);
    }, 300);
  } else{
    sliding(true);
  }
}

function rightSliding(){
  index++;
  if(index >= slides.length - 1){
    sliding(true);
    index = 1;

    setTimeout(() => {
      sliding(false);
    }, 300);
  } else{
    sliding(true);
  }
}

function sliding(state){
  if(state == true){
    slides.forEach(function(slide){
      slide.style.transition = "all .3s";
    });
  } else{
    slides.forEach(function(slide){
      slide.style.transition = "none";
    });
  }

  slides.forEach(function(slide){
    slide.style.transform = `translateX(${index * (-100)}%)` ;
  })
}