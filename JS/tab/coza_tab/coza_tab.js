let btns = document.querySelectorAll(".tab_btn");
let contents = document.querySelectorAll(".all");

for(let i=0;i<btns.length;i++){
  btns[i].addEventListener("click", tabIdCalculator);
}

//초기화
// window.addEventListener("load", defaultShow);

// function defaultShow(){
//   btns[0].classList.add("btnCSS");

//   for(let i=0;i<contents.length;i++){
//     contents[i].classList.add("showContent");
//   }
// }

activeTab(btns[0]);
showTabContent("all");


// let imgEnter = document.querySelector(".imgbox");
// imgEnter.addEventListener("mouseenter", function(){
//   imgEnter.img.style.transform = "scale(1.2)";
// });

// let imgLeave = document.querySelector(".imgbox");
// imgLeave.addEventListener("mouseleave", function(){
//   imgEnter.img.style.transform = "scale(1.0)";
// });

function tabIdCalculator(){
  let tabId = this.id;

  activeTab(this);
  showTabContent(tabId);
}

// 선택된 버튼에 대한 css
function activeTab(btn){
  for(let i=0;i<btns.length;i++){
    btns[i].classList.remove("btnCSS");
  }
  btn.classList.add("btnCSS");
}

// 선택된 버튼의 id와 동일한 class 값을 가진 content show
function showTabContent(tabId){
  for(let i=0;i<contents.length;i++){
    contents[i].classList.remove("showContent");
  }

  let activeContent = document.querySelectorAll("." + tabId);
  if(activeContent){
    for(let i=0;i<contents.length;i++){
      activeContent[i].classList.add("showContent");
    }
  }
}


let modal = document.querySelector(".modal");
let images = document.querySelectorAll("img");

for(let i=0;i<images.length;i++){
  images[i].addEventListener("click", showModal);
}

function showModal(){
  let imgID = this.id + "_modal";
  console.log(imgID);

  let modal_img = document.querySelector("." + imgID);
  if(modal_img){
    modal.style.display = "block";
    modal_img.style.display = "block";
  }
}


let close = document.querySelectorAll(".close");
for(let i=0;i<close.length;i++){
  close[i].addEventListener("click", closeModal);
}


modal.addEventListener("click", function(event){
  // this: , target: 실제로 이벤트가 발생한 구체적인 영역
  if(event.target === modal){
    for(let i=0;i<images.length;i++){
      modal.style.display = "none";
    }
  }
});

function closeModal(){
  for(let i=0;i<images.length;i++){
    modal.style.display = "none";
  }
}


// header 고정
let headerTop = document.querySelector(".h_top");
let offset = headerTop.offsetHeight;

window.addEventListener("scroll", function(){
  if(this.window.scrollY > offset){
    headerTop.classList.add("scrolled");
    // headerBottom.style.top = 0;
  } else{
    headerTop.classList.remove("scrolled");
    // headerBottom.style.top = offset + "px";
  }
})