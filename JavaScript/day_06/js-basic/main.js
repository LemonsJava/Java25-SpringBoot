//https://dummyjson.com/products

function getProducts() {
  return fetch("https://dummyjson.com/products").then(function (response) {
    return response.json(); // convert du lieu thanh JSON;
  });
}

function renderProducts(products = []) {
  const productListEl = document.querySelector(".products");

  const html = products
    .map(function (product) {
      const productHtml = [
        `<div>`,
        `<div class="product-image">`,
        `<img src="${product.thumbnail}" alt="${product.title}" />`,
        `</div>`,
        `<div class="product-info">`,
        `<h3 class="product-title">${product.title}</h3>`,
        `<p class="product-price">${product.price}</p>`,
        `</div>`,
        `<div>`,
        `<button class="add-to-cart" data-product-id="${product.id}">Add to cart</button>`,
        `</div>`,
        `</div>`,
      ].join("");

      return productHtml;
    })
    .join("");

  productListEl.innerHTML = html;
}

//B1: Goi API va tra ve kq

//B2: Convert du lieu nhan duoc ra JSON

function setupEventHandlers() {
  document
    .querySelectorAll("button.btn-add-to-cart")
    .forEach(function (button) {
      button.addEventListener("click", function () {
        const productId = button.getAttribute("data-product-id");
        alert("Add product with ID: " + ${productId} + " to cart");
      });
    });
}

function main() {
  getProducts()
    .then(function (data) {
      renderProducts(data.products); // In ra danh sach san pham theo HTML
    })
    .then(function () {
      setupEventHandlers(); // Khoi tao va goi ham setupEventHandlers
    });
}

main(); // Khoi tao va goi ham main
