// Int data
let todoList = [];

const apiUrl = "http://localhost:8000/todo-list";

const inputTodo = document.querySelector("#input-todo");
const btnAdd = document.querySelector("#btn-add");
const btnSearch = document.querySelector("#btn-search");

// Goi API de lay du lieu va hien thi ra ngoai giao dien

const getAllTodos = async () => {
  try {
    let response = await axios.get(apiUrl);
    console.log(response);
    todoList = response.data;
    renderTodo(todoList);
  } catch (error) {
    console.log(error);
  }
};

//Hiển thị danh sách công việc ban đầu, nếu không có công việc nào trong danh sách thì hiển thị Danh sách công việc trống
const todoContainer = document.querySelector("ul");
const renderTodo = (todoList) => {
  if (todoList.length == 0) {
    todoContainer.innerHTML = "<li>Không có công việc trong danh sách</li>";
    return;
  }
  let html = "";
  todoList.forEach((todo) => {
    html += `
            <li>
                <input onchange="isComplete(${todo.id})" type="checkbox" ${
      todo.status ? "checked" : ""
    }>
                <span class=${todo.status ? "active" : ""}>${todo.title}</span>
                <button onclick="editTodo(${todo.id})">Edit</button>
                <button onclick="deleteTodo(${todo.id})">Delete</button>
            </li>`;
  });
  todoContainer.innerHTML = html;
};
renderTodo(todoList);

// const createId = () => {
//   //return Math.floor(Math.random() * 1000000);
//   if (todoList.length === 0) {
//     return 1;
//   }
//   return Math.max(...todoList.map((todo) => todo.id)) + 1;
// };

//Thêm công việc mới (nếu title rỗng -> alert “Tên công việc không được để trống”)

btnAdd.addEventListener("click", async () => {
  // lấy ra dữ liệu trong ô input
  const newTitle = inputTodo.value.trim();
  if (newTitle.length == 0) {
    alert("Tên công việc không được để trống");
    return;
  }
  // tạo 1 công việc mới
  const newTodo = {
    // id: createId(),
    title: newTitle,
    status: false,
  };

  // Goi API de them cong viec moi
  try {
    let response = await axios.post(apiUrl, newTodo);
    // thêm vào cuối mảng todos
    todoList.push(response.data);
    //render lại giao diện
    renderTodo(todoList);
    // clear dữ liệu trong ô input
    inputTodo.value = "";
  } catch (error) {
    console.log(error);
  }
});

//Xóa công việc (cần confirm trước khi xóa, sử dụng window.confirm)
const deleteTodo = async (id) => {
  const isDelete = confirm("Bạn chắc chắn có muốn xóa không?");
  if (!isDelete) return;

  // Goi API de xoa cong viec
  try {
    await axios.delete(`${apiUrl}/${id}`);
    const index = todoList.findIndex((todo) => todo.id === id);
    todoList.splice(index, 1);
    renderTodo(todoList);
  } catch (error) {
    console.log(error);
  }
};

//Chỉnh sửa tiêu đề công việc (sử dụng window.prompt cho đơn giản)
const editTodo = async (id) => {
  const todo = todoList.find((todo) => todo.id === id);
  const newTodo = prompt("Cập nhật tiêu đề công việc", todo.title);
  if (newTodo === null) return;
  if (newTodo.trim().length === 0) {
    alert("Tên công việc không để trống !");
    return;
  }

  //Goi API de chinh sua tieu de cong viec
  const data = {
    title: newTodo,
    status: todo.status,
  };
  try {
    let response = await axios.patch(`${apiUrl}/${id}`, data);
    todo.title = response.data.title;
    renderTodo(todoList);
  } catch (error) {
    console.log(error);
  }
};

//Thay đổi trạng thái công việc (status)
const isComplete = async (id) => {
  const todo = todoList.find((todo) => todo.id === id);

  //Goi API de chinh sua trang trai cong viec
  try {
    const data = {
      status: !todo.status,
    };

    let response = await axios.patch(`${apiUrl}/${id}`, data);
    todo.status = response.data.status;
    renderTodo(todoList);
  } catch (error) {
    console.log(error);
  }
};

// “Tìm kiếm todo theo title” sử dụng full-text search trong Json Server
btnSearch.addEventListener("click", async () => {
  const keyword = inputTodo.value.trim();
  if (keyword.length == 0) {
    alert("Tiêu đề tìm kiếm không được để trống!");
    getAllTodos();
    return;
  }
  try {
    let response = await axios.get(`${apiUrl}?q=${keyword}`);
    todoList = response.data;
    renderTodo(todoList);
    inputTodo.value = "";
  } catch (error) {
    console.log(error);
  }
});
// Hien thi todo-list ra ngoai giao dien khi load trang
getAllTodos();
