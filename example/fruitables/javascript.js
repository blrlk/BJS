// pages dropdown
let menuTab = document.querySelector(".menuTab")
let submenu = document.querySelector(".submenu");
menuTab.addEventListener("click", submenuShow);

let cnt=0;
function submenuShow(){
  cnt++;
  if(cnt%2 == 1){
    // submenu.classList.add("show");
    submenu.style.display = "block";
  } else{
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
let slides = document.querySelectorAll(".sliders li");
console.log(slides);

left.addEventListener("click", leftsliding);
right.addEventListener("click", rightsliding);

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


setInterval(rightsliding, 3000);

let index=0;
function leftsliding(){
  index--;
  if(index < 0){
    index = slides.length -1;
  }
  
  slides.forEach(function(slide){
    slide.style.transform = `translate(${index * (-100)}%)`;
  })
}

function rightsliding(){
  index++;
  if(index >= slides.length){
    index = 0;
  }
  
  slides.forEach(function(slide){
    slide.style.transform = `translate(${index * (-100)}%)`;
  })
}

function changeCSS_left(){
  left.style.opacity = 1;
}

function changeCSS_right(){
  right.style.opacity = 1;
}

function changeCSS_out(){
  right.style.opacity = 0.5;
  left.style.opacity = 0.5;
}


// tab
let tabs = document.querySelectorAll(".tabbtn");
let contents = document.querySelectorAll(".all");
console.log(tabs);

for(let i=0;i<tabs.length;i++){
  tabs[i].addEventListener("click", tabShow);
}

displayContent("all");
changebg("all");

function tabShow(){
  let crrntID = this.id;
  console.log(crrntID);

  displayContent(crrntID);
  changebg(crrntID);
}

function displayContent(crrntID){
  let show = document.querySelectorAll("." + crrntID);
  console.log(show);

  for(let i=0;i<contents.length;i++){
    contents[i].style.display = "none";
  }

  for(let i=0;i<show.length;i++){
    show[i].style.display = "block";
  }
}

function changebg(crrntID){
  let bg = document.querySelector("#" + crrntID);
  for(let i=0;i<tabs.length;i++){
    tabs[i].style.backgroundColor = "#F4F6F8";
  }
  bg.style.backgroundColor = "#ffb524";
}

// advertise 색상
window.onload = function(){
  let borderColor = ["#ffb524", "#45595b", "#81c408"];
  let txtboxColor = ["#81c408", "white", "#ffb524"];
  let subtitleColor = ["white", "#81c408", "white"];

  let borders = document.querySelectorAll("#advertise .box");
  let boxes = document.querySelectorAll("#advertise .color");
  let txtboxes = document.querySelectorAll("#advertise .txtbox");
  let subtitles = document.querySelectorAll("#advertise .txtbox p");

  for(let i=0;i<3;i++){
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

window.addEventListener("scroll", function(){
  if(window.scrollY > offset){
    hBottom.classList.add("scrolled");
  } else{
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

searchbtn.addEventListener("click", function(){
  modal.style.display = "block";
});

let close = document.querySelector(".close");
close.addEventListener("click", function(){
  modal.style.display = "none";
});