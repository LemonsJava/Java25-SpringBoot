// Vừa vào trang gọi API load danh sách tỉnh - thành phố (province) và hiển thị lên trên giao diện
// Khi người dùng chọn 1 tỉnh - thành phố (province) cụ thể thì tiếp tục gọi API để lấy danh sách quận - huyện (district) tương ứng với tỉnh - thành phố đã chọn trước đó
// Làm tương tự với xã phường (commune)

const provinceSelect = document.getElementById("province");
const districtSelect = document.getElementById("district");
const communeSelect = document.getElementById("commune");

// Lấy danh sách tỉnh - thành phố (province)
const getAllProvinces = async () => {
  try {
    const response = await axios.get("https://provinces.open-api.vn/api/p/");
    response.data.forEach((province) => {
      const option = document.createElement("option");
      option.value = province.code;
      option.innerText = province.name;
      provinceSelect.appendChild(option);
    });
  } catch (error) {
    console.error(error);
  }
};

getAllProvinces();
