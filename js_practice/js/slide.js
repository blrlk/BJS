let left = document.querySelector(".left");
let right = document.querySelector(".right");
let slides = document.querySelectorAll(".slide");
let slidebox = document.querySelector(".slidebox");

let firstContent = slides[0].cloneNode(true);
let lastContent = slides[slides.length - 1].cloneNode(true);
slidebox.appendChild(firstContent);
slidebox.insertBefore(lastContent, slides[0]);
slides = document.querySelectorAll(".slide");

left.addEventListener("click", leftsliding);
right.addEventListener("click", rightsliding);

setInterval(rightsliding, 3000);

let index = 1;
sliding(true);

function leftsliding() {
  index--;
  if (index <= 0) {
    sliding(true);
    index = slides.length - 2;

    setTimeout(() => {
      sliding(false);
    }, 300);
  } else {
    sliding(true);
  }
}

function rightsliding() {
  index++;
  if (index >= slides.length - 1) {
    sliding(true);
    index = 1;

    setTimeout(() => {
      sliding(false);
    }, 300);
  } else {
    sliding(true);
  }
}

function sliding(state) {
  if (state == true) {
    slides.forEach(function (slide) {
      slide.style.transition = "all .3s";
    })
  } else {
    slides.forEach(function(slide){
      slide.style.transition = "none";
    })
  }

  slides.forEach(function (slide) {
    slide.style.transform = `translateX(${index * (-100)}%)`;
  });
}

