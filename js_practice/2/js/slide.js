// basic
let left = document.querySelector(".left");
let right = document.querySelector(".right");
let slides = document.querySelectorAll(".slide");
let slidebox = document.querySelector(".slides");
console.log(slides.length);

let firstContent = slides[0].cloneNode(true);
let lastContent = slides[slides.length - 1].cloneNode(true);
slidebox.appendChild(firstContent);
slidebox.insertBefore(lastContent, slides[0]);
slides = document.querySelectorAll(".slide");
console.log(slides.length);


left.addEventListener("click", leftSliding);
right.addEventListener("click", rightSliding);

setInterval(rightSliding, 3000);

let index = 1;
sliding(false);

function leftSliding() {
  index--;
  if (index <= 0) {
    index = slides.length - 2;
    sliding(true);

    setTimeout(() => {
      sliding(false)
    }, 300);
  } else {
    sliding(true);
  }
}

function rightSliding() {
  index++;
  if (index >= slides.length - 1) {
    sliding(true);
    index = 1;

    setTimeout(() => {
      sliding(false)
    }, 300);
  } else {
    sliding(true);
  }
}

function sliding(state) {
  if (state == true) {
    slides.forEach(function (slide) {
      slide.style.transition = "all .3s";
    });
  } else {
    slides.forEach(function (slide) {
      slide.style.transition = "none";
    });
  }

  slides.forEach(function (slide) {
    slide.style.transform = `translateX(${index * (-100)}%)`;
  });
}

// vertical
let up = document.querySelector(".up");
let down = document.querySelector(".down");
let slidesV = document.querySelectorAll(".slideV");
let slideboxV = document.querySelector(".slidesV");
console.log(slidesV.length);

let firstContentV = slidesV[0].cloneNode(true);
let lastContentV = slidesV[slidesV.length - 1].cloneNode(true);
slideboxV.appendChild(firstContentV);
slideboxV.insertBefore(lastContentV, slidesV[0]);
slidesV = document.querySelectorAll(".slideV");
console.log(slidesV.length);


up.addEventListener("click", upSliding);
down.addEventListener("click", downSliding);

let indexV = 1;
slidingV(false);

setInterval(downSliding, 2000);

function upSliding() {
  indexV--;
  if (indexV <= 0) {
    slidingV(true);
    indexV = slidesV.length - 2;

    setTimeout(() => {
      slidingV(false);
    }, 300);
  } else {
    slidingV(true);
  }
}

function downSliding() {
  indexV++;
  if (indexV >= slidesV.length - 1) {
    slidingV(true);
    indexV = 1;

    setTimeout(() => {
      slidingV(false);
    }, 300);
  } else {
    slidingV(true);
  }
}

function slidingV(state) {
  if (state == true) {
    slidesV.forEach(function (slide) {
      slide.style.transition = "all .3s";
    })
  } else {
    slidesV.forEach(function (slide) {
      slide.style.transition = "none";
    })
  }

  slidesV.forEach(function (slide) {
    slide.style.transform = `translateY(${indexV * (-100)}%)`;
  })
}

// button
let btn = document.querySelectorAll(".btn");
let slidesB = document.querySelectorAll('.slideB');

let indexB = 0;
btn.forEach(function (btn) {
  btn.addEventListener("click", btnSlide);
})

function btnSlide() {
  // console.log(this.id);
  indexB = parseInt(this.id.slice(-1));
  // console.log(indexB);

  slidesB.forEach(function(slide){
    slide.style.transform = `translateX(${indexB * (-100)}%)`;
  })
}