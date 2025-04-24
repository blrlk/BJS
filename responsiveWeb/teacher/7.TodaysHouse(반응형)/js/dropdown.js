// 글쓰기
let dropBtn = document.querySelector("header .dropdown");
let subMenu = document.querySelector("header .dropdown ul");

dropBtn.addEventListener("click", showMenu);

function showMenu() {
  subMenu.classList.toggle("show");
}

// 커뮤니티
let navItems = document.querySelectorAll("header .menu li");
let ulNodes = document.querySelectorAll("header .submenu ul");

navItems.forEach(function (item) {
  item.addEventListener("mouseenter", showMyMenu);
  item.addEventListener("mouseleave", removeMyMenu);
});

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
