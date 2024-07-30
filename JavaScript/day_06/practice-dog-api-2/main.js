const btn = document.getElementById("btn");
const image = document.getElementById("image");
const breedList = document.getElementById("breed-list");

// Vừa load trang phải gọi API để render danh sách breed
async function getBreedList() {
  try {
    // Gọi API để lấy danh sách giống loài
    let res = await axios.get("https://dog.ceo/api/breeds/list/all");

    // Sau khi có data thì hiển thị kết quả trên giao diện
    renderBreed(res.data.message);
  } catch (error) {
    console.error("Error fetching breed list:", error);
  }
}

function renderBreed(breeds) {
  // Duyệt qua object breeds -> tạo thẻ option -> gắn vào DOM
  const fragment = document.createDocumentFragment(); //tạo một đối tượng DocumentFragment trống

  for (let breed in breeds) {
    const option = document.createElement("option");
    option.value = breed;
    option.textContent = breed;
    fragment.appendChild(option); // thêm toàn bộ DocumentFragment vào phần tử select trong DOM
    // Khi này, tất cả các thẻ option sẽ được thêm vào DOM cùng một lúc, giảm thiểu số lần thao tác trực tiếp lên DOM.
  }

  breedList.appendChild(fragment);
}

async function fetchRandomImage(breed) {
  try {
    // Gọi API để lấy hình ảnh ngẫu nhiên của giống loài đã chọn
    let res = await axios.get(
      `https://dog.ceo/api/breed/${breed}/images/random`
    );

    // Hiển thị hình ảnh trên giao diện
    image.src = res.data.message;
  } catch (error) {
    console.error("Error fetching image:", error);
  }
}

// Thêm sự kiện click cho button
btn.addEventListener("click", function () {
  const selectedBreed = breedList.value;
  fetchRandomImage(selectedBreed);
});

// Gọi hàm để render danh sách breed khi load trang
getBreedList();
