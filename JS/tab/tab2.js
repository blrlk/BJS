let tabs = document.querySelectorAll(".tab");
let contents = document.querySelectorAll(".tab-content");

for(let i=0;i<tabs.length;i++){
  tabs[i].addEventListener("click", tabIdCalculator);
}

function tabIdCalculator(){
  let tabId = "content-" + this.id;

  activeTab(this);
  showTabContent(tabId);
}

// 전부 다 삭제시키고 매개변수로 받아온 tab의 class만 활성화시킴 -> 배경색 변경
function activeTab(tab){
  for(let i=0;i<tabs.length;i++){
    tabs[i].classList.remove('active');
  }
  tab.classList.add('active');
}

// 전부 다 삭제시키고 매개변수로 받아온 tabId를 ID 값으로 가지는 content에 대해 active id 값 부여 -> content display
function showTabContent(tabId){
  for(let i=0;i<contents.length;i++){
    contents[i].classList.remove('active');
    // activeContent.style.display="none";
  }

  let activeContent = document.querySelector("#" + tabId);
  console.log(activeContent);
  if(activeContent){
    activeContent.classList.add('active');
    // activeContent.style.display="block";
  }
}