const modalTrailer = document.getElementById("modal-trailer");
let videoTrailer = document.getElementById("video-trailer");

modalTrailer.addEventListener('hidden.bs.modal', function () {
    videoTrailer.src = videoTrailer.src;
})

//Rating-stars logic rating

const stars = document.querySelectorAll(".rating .star");
const ratingValue = document.getElementById("rating-value");

const formReviewEl = document.getElementById("form-review");
const reviewContentEl = document.getElementById("review-content");
const modalReviewEl = document.getElementById("modalReview");
const modalReviewInstance = new bootstrap.Modal('#modalReview', {
    keyboard: false
})
let updatedId = null;

let selectedRating = 0;

stars.forEach((star) => {
    star.addEventListener("mouseover", () => {
        resetStars();
        const rating = parseInt(star.getAttribute("data-rating"));
        highlightStars(rating);
    });

    star.addEventListener("mouseout", () => {
        resetStars();
        highlightStars(selectedRating);
    });

    star.addEventListener("click", () => {
        selectedRating = parseInt(star.getAttribute("data-rating"));
        ratingValue.textContent = `Bạn đã đánh giá ${selectedRating} sao.`;
        highlightStars(selectedRating);
    });
});

function resetStars() {
    stars.forEach((star) => {
        star.classList.remove("active");
    });
}

function highlightStars(rating) {
    stars.forEach((star) => {
        const starRating = parseInt(star.getAttribute("data-rating"));
        if (starRating <= rating) {
            star.classList.add("active");
        }
    });
}

//Hiển thị danh sách review

const reviewListEl = document.querySelector(".review-list");
const renderReviews = (listReviews) => {
    let html = "";
    listReviews.forEach((review) => {
        console.log(review.id);
        html += `
            <div class="rating-item d-flex align-items-center mb-3 pb-3">
                <div class="rating-avatar">
                    <img src="${review.user.avatar}" alt="${review.user.name}">
                </div>
                <div class="rating-info ms-3">
                    <div class="d-flex align-items-center">
                        <p class="rating-name mb-0"><strong>${review.user.name}</strong></p>
                        <p class="rating-time mb-0 ms-2">${formatDate(review.createdAt)}</p>
                    </div>
                    <div class="rating-star">
                        <p class="mb-0 fw-medium">
                            <span class="rating-icon me-1"><i class="fa fa-star"></i></span>
                            <span>${review.rating}/10</span>
                        </p>
                    </div>
                    <p class="rating-content mt-1 mb-0 text-muted">${review.content}</p>
                    ${currentUser != null && currentUser.id == review.user.id ?
            `
                            <div>
                                <button
                                    onclick="openModalReviewUpdate(${review.id})"
                                    class="text-primary border-0 bg-transparent me-1">Sửa</button>
                                <button
                                    onclick="deleteReview(${review.id})"
                                    class="text-danger border-0 bg-transparent me-1">Xóa
                                </button>
                            </div>
                        ` : ''
        }
                </div>
            </div>
        `
    });
    reviewListEl.innerHTML = html;
};


//popup modal
modalReviewEl.addEventListener('show.bs.modal', event => {
    const modalTitle = document.querySelector("#modalReview .modal-title");
    const formBtn = document.querySelector("#form-review button[type='submit']");

    if (updatedId) {
        modalTitle.textContent = "Cập nhật bình luận";
        formBtn.textContent = "Cập nhật";
    } else {
        modalTitle.textContent = "Tạo bình luận";
        formBtn.textContent = "Tạo bình luận";
    }
})

modalReviewEl.addEventListener('hidden.bs.modal', event => {
    selectedRating = 0;
    resetStars();
    ratingValue.textContent = "Vui lòng chọn đánh giá";
    reviewContentEl.value = "";
    updatedId = null;
})


//format date
const formatDate = dateString => {
    const date = new Date(dateString);
    const year = date.getFullYear();
    const month = ("0" + (date.getMonth() + 1)).slice(-2); // 09 -> 09 , 011 -> 11
    const day = ("0" + date.getDate()).slice(-2);
    return `${day}/${month}/${year}`;
}


formReviewEl.addEventListener("submit", (e) => {
    e.preventDefault();

    if (updatedId) {
        editReview();
    } else {
        createReview();
    }

})


//Tạo review
const createReview = async () => {
    if (selectedRating === 0) {
        toastr.warning('Vui lòng chọn số sao');
        return;
    }

    if (reviewContentEl.value.trim() === "") {
        toastr.warning('Vui lòng nhập nội dung bình luận');
        return;
    }

    const request = {
        rating: selectedRating,
        content: reviewContentEl.value,
        movieId: movieDetail.id
    }
    console.log(request);

    try {
        let res = await axios.post("/api/reviews", request);
        console.log(res.data)
        listReviews.unshift(res.data);
        render(listReviews);
        modalReviewInstance.hide();
        toastr.success('Tao bình luận thành công');
    } catch (error) {
        console.log(error);
        toastr.error(error.response.data.message);
    }
}


//Cập nhật review

const editReview = async () => {
    if (reviewContentEl.value.trim() === "") {
        toastr.warning('Vui long nhap nội dung bình luận');
    }

    const reviewData = {
        rating: selectedRating,
        content: reviewContentEl.value.trim()
    }

    try {
        let res = await axios.put(`/api/reviews/${updatedId}`, reviewData);
        console.log(res.data);
        listReviews = listReviews.map(review => {
            if (review.id === updatedId) {
                return res.data;
            }
            return review;
        });
        render(listReviews);
        modalReviewInstance.hide();
        toastr.success('Cập nhật bình luận thành công');
    } catch (error) {
        console.log(error);
        toastr.error(error.response.data.message);
    }
}

//Xóa review

const deleteReview = async (reviewId) => {
    const isConfirm = window.confirm("Bạn có chắc chắn muốn xóa đánh giá này không?");
    if (!isConfirm) return;

    try {
        let res = await axios.delete(`/api/reviews/${reviewId}`);
        console.log(res.data);
        listReviews = listReviews.filter(review => review.id !== reviewId);
        render(listReviews);
        toastr.success('Xóa bình luận thành công');
    } catch (error) {
        console.log(error);
        toastr.error(error.response.data.message);
    }
}

const openModalReviewUpdate = (id) => {
    updatedId = id; // Lưu lại id review cần cập nhật
    modalReviewInstance.show(); // Hiển thị modal

    // Tìm kiếm thông tin review cần cập nhật
    const review = listReviews.find(review => review.id === id);

    // Hiển thị thông tin review lên form
    selectedRating = review.rating;
    ratingValue.textContent = `Bạn đã đánh giá ${selectedRating} sao.`;
    highlightStars(selectedRating);
    reviewContentEl.value = review.content;
}

const render = () => {
    $('#review-pagination').pagination({
        dataSource: listReviews,
        pageSize: 5,
        showPrevious: false,
        showNext: false,
        callback: function (data, pagination) {
            renderReviews(data);
        }
    })
}


// render list review
render();






