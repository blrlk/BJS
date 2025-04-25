let itemList = [];  //배열변수를 선언

//Step 1 : 요소를 Select 한다.
let addBtn = document.querySelector('#add');

// Step2 : 이벤트 핸들러 등록하기
addBtn.addEventListener("click", addList);

function addList() {
  let item = document.querySelector('#item').value.trim();
  
  // 인풋상자의 내용이 공백이 아니면 배열 끝에 추가
  if (item != null && item !="") {
    itemList.push(item);      

    //item을 배열에 추가 후, input요소 초기화 및 포커스 잡기
    document.querySelector("#item").value = "";
    document.querySelector("#item").focus();
  }
  else{
    console.log("입력된 준비물 내용이 없습니다");
    document.querySelector("#item").value = "";
    document.querySelector("#item").focus();
  }
  showList();
}

// 최종기능 : 아이템 배열에 있는 값들을 html에 출력
// 최종 형태 : <ul><li>aaa<span>x</span></li></ul>
function showList() {
  document.querySelector("#itemList").innerHTML="<h1>준비할 목록</h1>";
  let list_ul = document.createElement("ul");

  /* 배열의 갯수만큼 반복한다. 형태 : <li>aaa<span>x</span></li>
    list는 HTML 코드를 쌓는 저장소
    list += "<li>" + itemList[i] + "<span class='close' id=" + i + ">X</span></li>";  
    요소와 삭제 버튼을 <li>~</li>로 묶음*/
  for (let i = 0; i < itemList.length; i++) {
    let input_li = document.createElement("li");//li태그 생성만(출력X)
    input_li.textContent = itemList[i]; //li태그 안의 텍스트(출력까지)
  

    let input_span = document.createElement("span"); //span태그 생성만 함(출력x)
    input_span.textContent = "X"; //span태그 안의 텍스트(출력까지)
    input_li.appendChild(input_span);
    list_ul.appendChild(input_li);

    input_span.setAttribute("id", i);
    input_span.setAttribute("class", "close");
    input_span.addEventListener("click", removeList);
  }

  document.querySelector("#itemList").appendChild(list_ul);
  console.log("ul태그 append 완료");
}

//클릭한 삭제 버튼의 아이템을 아이템 배열에서 삭제.
function removeList() {
 // this(클릭한 삭제 버튼)의 id 값 가져와 id 변수에 저장
  let id = this.getAttribute("id"); 
  //자신이 선택한 버튼이 맞는지 확인
  console.log(id);
  // itemList 배열에서 인덱스 값이 id인 요소 1개 삭제
  itemList.splice(id, 1); 
  // 변경된 itemList 배열을 다시 화면에 표시
  console.log("배열 삭제 완료");
  showList();
}