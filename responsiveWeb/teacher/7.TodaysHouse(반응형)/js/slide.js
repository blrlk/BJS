let left = document.querySelector("#main .left");
let right = document.querySelector("#main .right");
let slides = document.querySelectorAll("#main .slide");

left.addEventListener("click", leftsliding);
right.addEventListener("click", rightsliding);

index = 0;
function leftsliding(){
  index--;
  if(index < 0){
    index = slides.length -1;
  }

  sliding();
}

function rightsliding(){
  index++;
  if(index >= slides.length){
    index = 0;
  }
  sliding();
}

function sliding(){
  slides.forEach(function(slide){
    slide.style.transform = `translateX(${index * (-100)}%)`;
  }); 
}
