let users = [];

//1. Lấy danh sách user (có phân trang)
const getUsers = async () => {
  try {
    let res = await axios.get("https://api.github.com/users");
    renderUser(res.data);
  } catch (error) {
    console.log(error);
  }
};

const tbody = document.querySelector("tbody");
const renderUser = (users) => {
  if (users.length === 0) {
    tbody.innerHTML = `
          <tr></tr>
            <td colspan="5" class="text-center">Không có user</td> 
          </tr>
        `;
    return;
  }
  let html = "";
  users.forEach((user) => {
    html += `
          <tr>
            <td>${user.id}</td>
            <td><img src="${user.avatar_url}" width="50" alt="${user.login}"></td>
            <td>${user.login}</td>
            <td>${user.html_url}</td>
            <td>${user.repos_url}</td>
          </tr>
        `;
  });
  tbody.innerHTML = html;
};
renderUser(users);

// Phân trang sử dụng PaginationJS

// 2. Tìm kiếm user theo tên (có phân trang)

const searchBtn = document.querySelector("button");
const inputUser = document.querySelector(".search-form-input");
searchBtn.addEventListener("click", async () => {
  if (inputUser.value.length === 0) {
    alert("Vui lòng nhập tên người dùng");
    return;
  }
  try {
    let res = await axios.get(
      `https://api.github.com/users/${inputUser.value}`
    );
    users = res.data;
    renderUser(users);
    inputUser.value = "";
  } catch (error) {
    console.log(error);
  }
});

getUsers();
