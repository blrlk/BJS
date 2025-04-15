// 준비할 목록 위치
let inventory = document.querySelector("#itemList");

// 버튼 클릭 시 이벤트 발생 - 목록 추가, 배경 변경
let btn = document.querySelector("#add");
btn.addEventListener("click", addList);
btn.addEventListener("mouseover", changBG_over);
btn.addEventListener("mouseout", changBG_out)

// over, out 시 배경색 변경
function changBG_over(){
  btn.style.backgroundColor = "yellow";
  btn.style.transition = "all .5s";
}
function changBG_out(){
  btn.style.backgroundColor = "white";
  btn.style.transition = "all .5s";
}

// 목록들을 담을 div 생성
let box = document.createElement("div");
inventory.appendChild(box);


// button 클릭 시 함수
function addList(){
  // input select
  let item = document.querySelector("#item");

  // 각각의 목록
  let boxes = document.createElement("p");
  box.appendChild(boxes);
  
  // input으로부터 값을 받아와서 각각의 목록 안에다가 span 태그로 값 넣기
  let valueTag = document.createElement("span");
  let value = document.createTextNode(item.value.trim());
  valueTag.appendChild(value);
  boxes.appendChild(valueTag);

  // X 표시를 위한 코드, 값과 동일하게 span 태그로 추가
  let closeTag = document.createElement("span");
  let close = document.createTextNode("X");
  closeTag.appendChild(close);
  boxes.appendChild(closeTag);



  // close 표시가 담겨있는 span 태그에 class명 부여
  // closeTag.className = "close" + cnt;
  closeTag.className = "close";

  let closeItem = document.querySelectorAll(".close");
  closeItem.forEach((index) => index.addEventListener("click", deleteItem));

  function deleteItem() {
    // console.log("remove() this : ", this);
    this.parentNode.remove();
    // this.parentNode.parentNode.removeChild(this.parentNode);
  }

  // 한 번에 추가
  // box.innerHTML += `<p><span>${item.value.trim()}</span><span>X</span>`;

  // 초기화 & input 요소 focus
  item.value = "";
  item.focus();
}
