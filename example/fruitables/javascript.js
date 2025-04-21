// pages dropdown
let menuTab = document.querySelector(".menuTab")
let submenu = document.querySelector(".submenu");
menuTab.addEventListener("click", submenuShow);

let cnt = 0;
function submenuShow() {
  cnt++;
  if (cnt % 2 == 1) {
    // submenu.classList.add("show");
    submenu.style.display = "block";
  } else {
    // submenu.classList.remove("show");
    submenu.style.display = "none";
  }

  // submenu.classList.toggle("show");
}

// 메뉴 버튼 초기 색상
let home = document.querySelector(".menu a:first-of-type");
console.log(home);
home.style.color = "#81c408";


// slide
let left = document.querySelector(".btn_left");
let right = document.querySelector(".btn_right");
let slides = document.querySelectorAll(".slide");
let slideUl = document.querySelector(".sliders")


// let leftClicked = false;
// let rightClicked = false;

// left.addEventListener("click", function(){
//   if(rightClicked){
//     right.style.opacity = 0.5
//   }
//   leftClicked = true;
//   left.style.opacity = 1;

// });

// left.addEventListener("mouseover", function(){
//   if(!leftClicked){
//     left.style.opacity = 1;
//   }
// });

// left.addEventListener("mouseout", function(){
//   if(!leftClicked){
//     left.style.opacity = 0.5;
//   }
// });

// right.addEventListener("click", function(){
//   if(leftClicked){
//     left.style.opacity = 0.5
//   }
//   rightClicked = true;
//   right.style.opacity = 1;
// });
// right.addEventListener("mouseover", function(){
//   if(!rightClicked){
//     right.style.opacity = 1;
//   }
// });
// right.addEventListener("mouseout", function(){
//   if(!rightClicked){
//     right.style.opacity = 0.5;
//   }
// });

left.addEventListener("click", leftsliding);
right.addEventListener("click", rightsliding);


let active = null; // 'left' or 'right'

left.addEventListener("click", () => {
  active = 'left';
  left.style.opacity = 1;
  right.style.opacity = 0.5;
});

right.addEventListener("click", () => {
  active = 'right';
  right.style.opacity = 1;
  left.style.opacity = 0.5;
});

// 클릭이 됐을 때는 어떤 over, out 스타일도 지정되어서는 안 됨
left.addEventListener("mouseover", () => {
  //왼쪽 버튼이 클릭이 안 됐을 때만 over, out 시 왼쪽 스타일 지정
  if (active !== 'left') {
    left.style.opacity = 1;
  }
});
left.addEventListener("mouseout", () => {
  if (active !== 'left') {
    left.style.opacity = 0.5;
  }
});

right.addEventListener("mouseover", () => {
  // 오른쪽 버튼이 클릭이 안 됐을 때만 over, out 시 오른쪽 스타일 지정
  if (active !== 'right') {
    right.style.opacity = 1;
  }
});
right.addEventListener("mouseout", () => {
  if (active !== 'right') {
    right.style.opacity = 0.5;
  }
});


let firstContent = slides[0].cloneNode(true);
let lastContent = slides[slides.length - 1].cloneNode(true);
slideUl.appendChild(firstContent);  //firstContent를 slideUl의 맨 마지막 자식으로 삽입
slideUl.insertBefore(lastContent, slides[0]); //lastContent를 slideUl의 자식 slides[0] 앞에 삽입
slides = document.querySelectorAll(".slide");
// 최종 slide -> slide[1] slide[0] slide[1] slide[0]

setInterval(rightsliding, 3000);

// 초기 디자인
let index = 1;
sliding(false); //애니메이션 없이 바로 위치 이동


function leftsliding() {
  index--;
  // 복제된 맨 앞 슬라이드로 이동한 경우
  if (index <= 0) {
    sliding(true);  //애니메이션 적용
    index = slides.length - 2;  //진짜 마지막으로 이동

    // 0.3초 후 순간이동
    setTimeout(() => {
      sliding(false);
    }, 300);
  } else {
    sliding(true);
  }
}

function rightsliding() {
  index++;
  // 복제된 맨 끝 슬라이드로 이동한 경우
  if(index >= slides.length -1){
    sliding(true);  //애니메이션 적용
    index = 1;  //진짜 첫 번째로 이동

    // 0.3초 후 순간이동
    setTimeout(() => {
      sliding(false);
    }, 300);
  } else{
    sliding(true);
  }
}

// state == true: 전환 효과 on, state == false: 전환 효과 off
function sliding(state){
  // 슬라이드 전환 효과 on/off
  if(state == true){
    slides.forEach(function(slide){
      slide.style.transition = 'all .3s';
    })
  } else{
    slides.forEach(function(slide){
      slide.style.transition = "none";
    })
  }

  // 슬라이드 위치 이동
  slides.forEach(function(slide){
    slide.style.transform = `translateX(${index * (-100)}%)`;
  })

  // return "transition: " + slides[0].style.transition;
}

function changeCSS_left() {
  left.style.opacity = 1;
}

function changeCSS_right() {
  right.style.opacity = 1;
}

function changeCSS_out() {
  right.style.opacity = 0.5;
  left.style.opacity = 0.5;
}


// tab
let tabs = document.querySelectorAll(".tabbtn");
let contents = document.querySelectorAll(".all");
console.log(tabs);

for (let i = 0; i < tabs.length; i++) {
  tabs[i].addEventListener("click", tabShow);
}

displayContent("all");
changebg("all");

function tabShow() {
  let crrntID = this.id;
  console.log(crrntID);

  displayContent(crrntID);
  changebg(crrntID);
}

function displayContent(crrntID) {
  let show = document.querySelectorAll("." + crrntID);
  console.log(show);

  for (let i = 0; i < contents.length; i++) {
    contents[i].style.display = "none";
  }

  for (let i = 0; i < show.length; i++) {
    show[i].style.display = "block";
  }
}

function changebg(crrntID) {
  let bg = document.querySelector("#" + crrntID);
  for (let i = 0; i < tabs.length; i++) {
    tabs[i].style.backgroundColor = "#F4F6F8";
  }
  bg.style.backgroundColor = "#ffb524";
}

// advertise 색상
window.onload = function () {
  let borderColor = ["#ffb524", "#45595b", "#81c408"];
  let txtboxColor = ["#81c408", "white", "#ffb524"];
  let subtitleColor = ["white", "#81c408", "white"];

  let borders = document.querySelectorAll("#advertise .box");
  let boxes = document.querySelectorAll("#advertise .color");
  let txtboxes = document.querySelectorAll("#advertise .txtbox");
  let subtitles = document.querySelectorAll("#advertise .txtbox p");

  for (let i = 0; i < 3; i++) {
    borders[i].style.border = `1px solid ${borderColor[i]}`;
    boxes[i].style.backgroundColor = borderColor[i];
    txtboxes[i].style.backgroundColor = txtboxColor[i];
    subtitles[i].style.color = subtitleColor[i];
  }
}

// h_bottom 고정
let hTop = document.querySelector("#h_top");
let hBottom = document.querySelector("#h_bottom");
let offset = hTop.offsetHeight;

window.addEventListener("scroll", function () {
  if (window.scrollY > offset) {
    hBottom.classList.add("scrolled");
  } else {
    hBottom.classList.remove("scrolled");
  }
})

// modal
// let inputKeyword = document.querySelector(".inputKeyword");
// inputKeyword.addEventListener("click", function(){
//   inputKeyword.style.outline = "10px solid #82c408d0";
// });

let modal = document.querySelector("#modal");
let searchbtn = document.querySelector(".search");
console.log(searchbtn);

searchbtn.addEventListener("click", function () {
  modal.style.display = "block";
});

let close = document.querySelector(".close");
close.addEventListener("click", function () {
  modal.style.display = "none";
});