let btns = document.querySelectorAll(".tab_btn");
let contents = document.querySelectorAll(".all");

for(let i=0;i<btns.length;i++){
  btns[i].addEventListener("click", tabIdCalculator);
}

// window.addEventListener("load", defaultShow);

// function defaultShow(){
//   btns[0].classList.add("btnCSS");

//   for(let i=0;i<contents.length;i++){
//     contents[i].classList.add("showContent");
//   }
// }

activeTab(btns[0]);
showTabContent("all");

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

// 선택된 버튼의 id와 동일한 class 값을 가진 content
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