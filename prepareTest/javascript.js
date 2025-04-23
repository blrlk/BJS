// dropdown
let btnDropdown = document.querySelector(".pages");
let contentDropdown = document.querySelector('.submenu');

btnDropdown.addEventListener("click", function () {

  contentDropdown.classList.toggle("showDropdown");
  btnDropdown.classList.toggle("btnDropdownCSS");
});

// slide
let btnSlide = document.querySelectorAll(".slidebtn div");
let slides = document.querySelectorAll(".slide");

btnSlide.forEach(function (btnslide) {
  btnslide.addEventListener("click", slideRight);
  btnslide.addEventListener("click", changebtn);
});

let index = 0;

function slideRight() {
  index = parseInt(this.id.charAt(this.id.length-1));
  
  slides.forEach(function(slide){
    slide.style.transform = `translateX(${index * (-100)}%)`;
  })
}

function changebtn() {
  btnSlide.forEach(function (btnslide) {
    btnslide.classList.remove("active");
  });

  this.classList.add("active");
}

// tab
let btnTab = document.querySelectorAll(".tabMenu button");
let contentTab = document.querySelectorAll(".all");

btnTab.forEach(function (btntab) {
  btntab.addEventListener("click", showTab);
});

showContent("all");
changeTab("all");

function showTab() {
  let crntID = this.id;
  console.log(crntID);

  showContent(crntID);
  changeTab(crntID);
}

function showContent(crntID) {
  let contents = document.querySelectorAll("." + crntID);

  contentTab.forEach(function(content){
    content.classList.remove("showContent");
  })

  if (contents) {
    contents.forEach(function (content) {
      content.classList.add("showContent");
    })
  }
}



function changeTab(crntID) {
  let nowTab = document.querySelector("#" + crntID);

  btnTab.forEach(function (btntab) {
    btntab.style.borderBottom = "3px solid #ebebeb";
  });

  nowTab.style.borderBottom = "3px solid var(--deepPointcolor)";
}