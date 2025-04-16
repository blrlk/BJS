let left = document.querySelector(".left");
let right = document.querySelector(".right");

let lis = document.querySelectorAll('#sliders li');

left.addEventListener("click", leftsliding);
right.addEventListener("click", rightsliding);

// let autoplay = setInterval(rightsliding, 3000);
setInterval(rightsliding, 3000); //3초마다 자동 실행

let index = 0;

function leftsliding(){
  index--;
  if(index<0){
    index = lis.length -1;
  }

  console.log("<");

  lis.forEach(function(slide){
    slide.style.transform = `translateX(${index*(-100)}%)`;
  })
}

function rightsliding(){
  index++;
  if(index>=lis.length){
    index = 0;
  }

  console.log(">");

  lis.forEach(function(slide){
    slide.style.transform = `translateX(${index*(-100)}%)`;
  })
}