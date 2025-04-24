// 글쓰기 dropdown
let btnWrite = document.querySelector(".wrtbtn");
let dropdownWrite = document.querySelector(".wrtdropdown");

btnWrite.addEventListener("click", function(){
  dropdownWrite.classList.toggle("show");
});

// fixed
let hTop = document.querySelector("#h_top");
let offset = hTop.offsetHeight;

window.addEventListener("scroll", function(){
  if(window.scrollY > offset){
    hTop.classList.add("scrolled");
  } else{
    hTop.classList.remove("scrolled");
  }
});

// rank slide
let slidesRank = document.querySelectorAll('.rnkslide');
let slideUlRank = document.querySelector('.rank');

let firstContent = slidesRank[0].cloneNode(true);
let lastContent = slidesRank[slidesRank.length-1].cloneNode(true);
slideUlRank.appendChild(firstContent);
slideUlRank.insertBefore(lastContent, slidesRank[0]);
slidesRank = document.querySelectorAll('.rnkslide');

setInterval(slide, 2000);

let indexRank = 1;
slidingRank(false);

function slide(){
  indexRank++;
  if(indexRank >= slidesRank.length-1){
    slidingRank(true);
    indexRank = 1;
    setTimeout(function(){
      slidingRank(false);
    }, 300);
  } else{
    slidingRank(true);
  }
}

function slidingRank(state){
  if(state == true){
    slidesRank.forEach(function(slide){
      slide.style.transition = 'all .3s';
    })
  } else{
    slidesRank.forEach(function(slide){
      slide.style.transition = 'none';
    })  
  }

  slidesRank.forEach(function(slide){
    slide.style.transform = `translateY(${indexRank * (-100)}%)`;
  })
}

// rank dropdown
let btnRank = document.querySelector(".rnkbtn");
let dropdownRank = document.querySelector(".rnkdropdown");

btnRank.addEventListener("click", function(){
  dropdownRank.classList.add("show");
});

let btnRank_close = document.querySelector(".rnkbtnClose");
btnRank_close.addEventListener("click", function(){
  dropdownRank.classList.remove("show");
});



// banner slide
let slidesBanner = document.querySelectorAll(".slide");
let slideUlBanner = document.querySelector(".slides");

let firstContent2 = slidesBanner[0].cloneNode(true);
let lastContent2 = slidesBanner[slidesBanner.length-1].cloneNode(true);
slideUlBanner.appendChild(firstContent2);
slideUlBanner.insertBefore(lastContent2, slidesBanner[0]);
slidesBanner = document.querySelectorAll('.slide');

let left = document.querySelector('.left');
let right = document.querySelector('.right');

left.addEventListener("click", slideLeft);
right.addEventListener("click", slideRight);

setInterval(slideRight, 3000);

let indexBanner = 1;
slidingBanner(false);

function slideLeft(){
  indexBanner--;
  if(indexBanner <= 0){
    slidingBanner(true);
    indexBanner = slidesBanner.length -2;

    setTimeout(() => {
      slidingBanner(false);
    }, 300);
  } else{
    slidingBanner(true);
  }
}

function slideRight(){
  indexBanner++;
  if(indexBanner >= slidesBanner.length-1){
    slidingBanner(true);
    indexBanner = 1;

    setTimeout(() => {
      slidingBanner(false);
    }, 300);
  } else{
    slidingBanner(true);
  }
}

function slidingBanner(state){
  if(state == true){
    slidesBanner.forEach(function(slide){
      slide.style.transition = 'all .3s';
    })
  } else{
    slidesBanner.forEach(function(slide){
      slide.style.transition = 'none';
    })  
  }

  slidesBanner.forEach(function(slide){
    slide.style.transform = `translateX(${indexBanner * (-100)}%)`;
  })
}

// menuTab dropdown
let btnMenuTab = document.querySelector(".mntbbtn");
let dropdownMenuTab = document.querySelector(".mntbdropdown");

btnMenuTab.addEventListener("click", function(){
  dropdownMenuTab.classList.toggle("show");
});

// css
let leftTopMenu = document.querySelectorAll(".menu li a");
let menuTab = document.querySelectorAll(".menuTab a");

  //초기 css
  leftTopMenu[0].classList.add("changeCSS");
  menuTab[0].classList.add("changeCSS");

for(let i=0;i<leftTopMenu.length;i++){
  leftTopMenu[i].addEventListener("click", changeTopMenu);
}

for(let i=0;i<menuTab.length;i++){
  menuTab[i].addEventListener("click", changeBottomMenu);
}

function changeTopMenu(){
  for(let i=0;i<leftTopMenu.length;i++){
    leftTopMenu[i].classList.remove("changeCSS");
  }
  console.log(this);
  this.classList.add("changeCSS");
}

function changeBottomMenu(){
  for(let i=0;i<menuTab.length;i++){
    menuTab[i].classList.remove("changeCSS");
  }
  console.log(this);
  this.classList.add("changeCSS");
}

// bestitem tab
let tabbtn = document.querySelectorAll(".bestTab button");
let contents = document.querySelectorAll(".bestgoods > div");

tabbtn.forEach(function(btn){
  btn.addEventListener("click", showbestitem);
});

showContent("all");
chgtabCSS("all");

function showbestitem(){
  let crntID = this.id;

  chgtabCSS(crntID);
  showContent(crntID);
}

function showContent(crntID){
  let show = document.querySelectorAll("." + crntID);

  for(let i=0;i<contents.length;i++){
    contents[i].style.display = "none";
  }
  for(let i=0;i<show.length;i++){
    show[i].style.display = "block";
  }
}

function chgtabCSS(crntID){
  let chgtab = document.querySelector('#' + crntID);

  for(let i=0;i<tabbtn.length;i++){
    tabbtn[i].style.backgroundColor = "#e9e9e9";
    tabbtn[i].style.color = "var(--black)";
  }
  chgtab.style.backgroundColor = "var(--pointColor)";
  chgtab.style.color = "white";
}

// mobile tab
let mobileOpen = document.querySelector(".hamburger > span");
let mobileClose = document.querySelector(".modal span");
let modal = document.querySelector(".modal");


mobileOpen.addEventListener("click", function(){
  modal.classList.toggle("showModal");
});

mobileClose.addEventListener("click", function(){
  modal.classList.toggle("showModal");
});