//Cach 1: su dung HTML attribute
const sayHello = () => {
    alert('Hello');
}
// Cach 2: su dung DOM property
const button2 = document.querySelector("#btn-2");
button2.onclick = function () {
    alert("Ban da click vao nut 2");
};

// Cach 3: su dung addEventListener
const button3 = document.querySelector("#btn-3");
button3.addEventListener("click", function () {
    alert("Ban da click vao nut 3");
})


const btnPlay = document.querySelector("#play");
const btnPause = document.querySelector("#pause");
const timeEle = document.querySelector("#time");
const messageEle = document.querySelector("#message");

let time = 10;
let interval;


// let interval = setInterval(() => {
//     time--;
//     timeEle.innerHTML = `${time}s`;
//     if (time <= 0) {
//         messageEle.innerHTML = "Time is up";
//         clearInterval(interval);
//     }
// }, 1000);

btnPlay.addEventListener("click", () => {
    interval = setInterval(() => {
        time--;
        timeEle.innerHTML = `${time}s`;
        if (time <= 0) {
            messageEle.innerHTML = "Time is up";
            clearInterval(interval);
            time = 10;
        }
    }, 1000);
});

btnPause.addEventListener("click", () => {
    clearInterval(interval);
});


const circle = document.createElement('div');
circle.style.width = '100px';
circle.style.height = '100px';
circle.style.backgroundColor = 'blue';
circle.style.borderRadius = '50%';
circle.style.position = 'absolute';

//Nhấn chuột vào 1 vị trí bất kỳ trên trang web, tạo 1 hình tròn tại vị trí nhấn chuột
//Mỗi lần nhấn chuột chỉ có 1 hình tròn được xuất hiện

document.addEventListener("click", (event) => {
    // Set position for circle
    circle.style.left = `${event.offsetX - 50}px`;
    circle.style.top = `${event.offsetY - 50}px`;
    document.body.appendChild(circle);
});


const users = [
    {
        id: 1,
        name: 'Nguyen Van A',
        age: 20
    },
    {
        id: 2,
        name: 'Nguyen Van B',
        age: 21
    },
    {
        id: 3,
        name: 'Nguyen Van C',
        age: 22
    },
    {
        id: 4,
        name: 'Nguyen Van D',
        age: 23
    },
    {
        id: 5,
        name: 'Nguyen Van E',
        age: 24
    },
    {
        id: 6,
        name: 'Nguyen Van F',
        age: 25
    },
    {
        id: 7,
        name: 'Nguyen Van G',
        age: 26
    },
    {
        id: 8,
        name: 'Nguyen Van H',
        age: 27
    },
    {
        id: 9,
        name: 'Nguyen Van I',
        age: 28
    },
    {
        id: 10,
        name: 'Nguyen Van J',
        age: 29
    }
];
const inputEle = document.querySelector("#input-name");
const btnShowAll = document.querySelector("#btn-show-all");
const listEle = document.querySelector("#list");

const renderUsers = (users) => {
    let html = "";
    users.forEach((user) => {
        html += `<li>${user.id} - ${user.name} - ${user.age}</li>`;
    });
    listEle.innerHTML = html;
};

inputEle.addEventListener("keydown", (event) => {
    if (event.key === "Enter") {
        // Lay keyword nhap vao
        const keyword = event.target.value;
        // Tim user theo keyword
        const filteredUsers = users.filter((user) => {
            return user.name.toLowerCase().includes(keyword.toLowerCase());
        });
        // Render lai danh sach user theo keyword
        renderUsers(filteredUsers);
    }
});

btnShowAll.addEventListener("click", () => {
    renderUsers(users);
});

const backToTop = document.querySelector("#back-to-top");

//Scroll back to top
window.addEventListener("scroll", () => {
    if (document.documentElement.scrollTop > 100) {
        backToTop.classList.remove("hide");
    } else {
        backToTop.classList.add("hide");
    }
});

backToTop.addEventListener("click", () => {
    window.scrollTo({ top: 0, behavior: "smooth" });
});



