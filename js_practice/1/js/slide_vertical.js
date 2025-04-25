let vSlides = document.querySelectorAll(".slide_v");
let vSlidebox = document.querySelector(".slidebox_v");
let up = document.querySelector(".up");
let down = document.querySelector('.down');

let VfirstContent = vSlides[0].cloneNode(true);
let VlastContent = vSlides[vSlides.length-1].cloneNode(true);
vSlidebox.appendChild(VfirstContent);
vSlidebox.insertBefore(VlastContent, vSlides[0]);
vSlides = document.querySelectorAll(".slide_v");

up.addEventListener("click", upsliding);
down.addEventListener("click", downsliding);

setInterval(downsliding, 3000);

let indexV = 1;
slidingV(false);

function upsliding(){
  indexV--;
  if(indexV <= 0){
    slidingV(true);
    indexV = vSlides.length-2;

    setTimeout(() => {
      slidingV(false);
    }, 300);
  }else{
    slidingV(true);
  }
}

function downsliding(){
  indexV++;
  if(indexV >= vSlides.length-1){
    slidingV(true);
    indexV = 1;

    setTimeout(() => {
      slidingV(false);
    }, 300);
  }else{
    slidingV(true);
  }
}

function slidingV(state){
  if(state == true){
    vSlides.forEach(function(vslide){
      vslide.style.transition = 'all .3s';
    })
  } else{
    vSlides.forEach(function(vslide){
      vslide.style.transition = 'none';
    })
  }

  vSlides.forEach(function(vslide){
    vslide.style.transform = `translateY(${indexV * (-100)}%)`;
  })
}