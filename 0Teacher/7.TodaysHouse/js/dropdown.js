// .h_top 글쓰기
let dropBtn = document.querySelector("header .dropdown");
let subMenu = document.querySelector("header .dropdown ul");

dropBtn.addEventListener("click", showMenu);

let isDropped = false;
function showMenu() {
  subMenu.classList.toggle("show");
  /*
  if(isDropped){
    subMenu.classList.remove("show");
    isDropped = !isDropped;
  }else {
    subMenu.classList.add("show");
    isDropped = !isDropped;
  }*/
}

// .h_bottom submenu
let navItems = document.querySelectorAll("header .menu li");
let headerSection = document.querySelector("header");
let ulNodes = document.querySelectorAll("header .submenu ul");

navItems.forEach(function (item) {
  item.addEventListener("mouseenter", showMyMenu);
});

headerSection.addEventListener("mouseleave", removeMyMenu);

function showMyMenu() {
  ulNodes.forEach(function(ul){
    ul.classList.remove("show");
  })

  let listClassName = this.id;
  let list = document.querySelector("." + listClassName);
  list.classList.add("show");
}

function removeMyMenu() {
  ulNodes.forEach(function(ul){
    ul.classList.remove("show");
  })

  ulNodes[0].classList.add("show");
}
