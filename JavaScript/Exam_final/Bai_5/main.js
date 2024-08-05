const API_URL = " https://jsonplaceholder.typicode.com";
const list = document.querySelector(".list");
const btnPost = document.querySelector("#btn1");
const btnPhoto = document.querySelector("#btn2");
const btnAlbum = document.querySelector("#btn3");
const h1 = document.querySelector("h1");
const btn = document.querySelectorAll("button");

// Su dung API de lay danh sach posts

async function renderEle(e) {
  try {
    const response = await axios.get(`${API_URL}/${e}`);
    h1.innerHTML = `<h1>Type: ${e}</h1>`;
    let html = "";
    console.log(response);
    response.data.forEach((el) => {
      html += `<li>${el.title}</li>`;
    });
    list.innerHTML = html;
  } catch (error) {
    console.log(error);
  }
}
renderEle("posts");

btnPost.addEventListener("click", () => {
  activeBtn(btnPost);
  renderEle("posts");
});

// Su dung API de lay danh sach photos
btnPhoto.addEventListener("click", async () => {
  activeBtn(btnPhoto);
  renderEle("photos");
});

// Su dung API de lay danh sach albums
btnAlbum.addEventListener("click", async () => {
  activeBtn(btnAlbum);
  renderEle("albums");
});

const activeBtn = (button) => {
  btn.forEach((but) => {
    but.classList.remove("active");
  });
  button.classList.add("active");
};
