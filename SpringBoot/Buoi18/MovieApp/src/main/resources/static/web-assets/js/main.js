const modalTrailer = document.getElementById("modal-trailer");
let videoTrailer = document.getElementById("video-trailer");

modalTrailer.addEventListener('hidden.bs.modal', function () {
    videoTrailer.src = videoTrailer.src;
})

//Rating-stars logic rating

const stars = document.querySelectorAll('.rating-star');
let ratingText = document.getElementById('rating-text');
let selectedRating = 0;

const modalRating = document.getElementById("modal-review-rating");

modalRating.addEventListener('hidden.bs.modal', function () {
    selectedRating = 0;
    resetStars();
    ratingText.innerText = `Chọn mức đánh giá`;
})


// Thêm sự kiện hover (mouseenter và mouseleave) cho mỗi ngôi sao
stars.forEach((star, index) => {
    star.addEventListener('mouseenter', () => {
        highlightStars(index);
    });

    star.addEventListener('mouseleave', () => {
        resetStars();
    });

    // Thêm sự kiện click để chọn ngôi sao
    star.addEventListener('click', () => {
        selectedRating = index + 1;
        updateSelectedStars(selectedRating);
        ratingText.innerText = `Bạn đã chọn mức đánh giá: ${selectedRating}/10`;
    });
});

// Đổi màu từ ngôi sao đầu đến ngôi sao hiện tại khi hover
function highlightStars(index) {
    for (let i = 0; i <= index; i++) {
        stars[i].classList.add('hover');
    }
}

// Đặt lại màu của các ngôi sao về mặc định khi không hover nữa
function resetStars() {
    stars.forEach(star => {
        star.classList.remove('hover');
    });

    updateSelectedStars(selectedRating); // Giữ lại màu của các ngôi sao đã chọn
}

// Cập nhật màu của các ngôi sao đã chọn
function updateSelectedStars(rating) {
    stars.forEach((star, index) => {
        if (index < rating) {
            star.classList.add('selected');
        } else {
            star.classList.remove('selected');
        }
    });
}