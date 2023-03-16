import React, { useEffect, useState } from 'react'
import axios from 'axios';

function Cart() {
  const [items, setItems] = useState([]);
  const [totalPrice, setTotalprice] = useState(0);

  const URL = "http://localhost:8080/api/v1/cartItems"
  useEffect(() => {
    const getData = async () => {
      try {
        const datas = await axios.get(`${URL}`)
        setItems(datas.data)
      } catch (error) {
        console.log(error)
      }
    }
    getData();
  }, [])

  const deleteItem = async (index) => {
    try {
      await axios.delete(`${URL}/${index}`)
    } catch (error) {
      console.log(error)
    }
    const newDatas = items.filter(e => e.id != index)
    setItems(newDatas);
  }

  const decrementItem = async (index) => {
    try {
      const rs = await axios.put(`${URL}/${index}/decrement`)
      const newDatas = items.map(e => {
        if (e.id === index) {
          e.count = e.count - 1;
        }
        return e;
      })
      setItems(newDatas)
    } catch (error) {
      console.log(error)
      alert(error.response.data.message)
    }
  }

  const incrementItem = async (index) => {
    try {
      await axios.put(`${URL}/${index}/increment`)
    } catch (error) {
      console.log(error)
    }
    const newDatas = items.map(e => {
      if (e.id === index) {
        e.count = e.count + 1;
      }
      return e;
    })
    setItems(newDatas)
  }

  useEffect(() => {
    let sum = 0;
    items.forEach(e => {
      sum += e.count * e.course.price;
    })
    setTotalprice(sum);
  })


  return (
    <div className="container">
      <div className="row">
        <div className="col-md-12">
          <div className="mb-4">
            <h2>Shopping Cart</h2>
          </div>
        </div>
      </div>
      {items.length === 0 &&
        <p className="fst-italic message">Không có sản phẩm trong giỏ hàng</p>
      }
      {items.length > 0 &&
        <div className="row shopping-cart">
          <div className="col-md-8">
            {items.map((e, index) => (
              <div className="product-list" key={index}>
                <div className="product-item d-flex border mb-4">
                  <div className="image">
                    <img src="https://images.unsplash.com/photo-1523381294911-8d3cead13475?ixlib=rb-4.0.3&amp;ixid=MnwxMjA3fDB8MHxzZWFyY2h8MTh8fGNsb3RoZXN8ZW58MHx8MHx8&amp;auto=format&amp;fit=crop&amp;w=800&amp;q=60" alt="sản phẩm" />
                  </div>
                  <div className="info d-flex flex-column justify-content-between px-4 py-3 flex-grow-1">
                    <div>
                      <div className="d-flex justify-content-between align-items-center">
                        <h2 className="text-dark fs-5 fw-normal">
                          Sản phẩm {index + 1}
                        </h2>
                        <h2 className="text-danger fs-5 fw-normal">
                          {e.course?.price} VND
                        </h2>
                      </div>
                      <div className="text-black-50">
                        <div className="d-inline-block me-3">
                          <button className="border py-2 px-3 d-inline-block fw-bold bg-light" onClick={() => decrementItem(e.id)}>-</button>
                          <span className="py-2 px-3 d-inline-block fw-bold">{e.count}</span>
                          <button className="border py-2 px-3 d-inline-block fw-bold bg-light" onClick={() => incrementItem(e.id)}>+</button>
                        </div>
                      </div>
                    </div>
                    <div>
                      <button className="text-primary border-0 bg-transparent fw-light" onClick={() => deleteItem(e.id)}>
                        <span>
                          <i className="fa-solid fa-trash-can"></i>
                        </span>
                        Xóa
                      </button>
                    </div>
                  </div>
                </div>
              </div>
            ))}
          </div>


          <div className="col-md-4">
            <div className="bill">
              <div className="border mb-2 p-3 fs-5 fw-normal d-flex justify-content-between align-items-center">
                <span className="text-black-50">Tạm tính:</span>
                <span className="text-primary" id="sub-total-money">{totalPrice} VND</span>
              </div>
              <div className="border mb-2 p-3 fs-5 fw-normal d-flex justify-content-between align-items-center">
                <span className="text-black-50">VAT (10%):</span>
                <span className="text-primary" id="vat-money">{totalPrice / 10} VND</span>
              </div>
              <div className="border mb-2 p-3 fs-5 fw-normal d-flex justify-content-between align-items-center">
                <span className="text-black-50">Thành tiền:</span>
                <span className="text-primary" id="total-money">{totalPrice + totalPrice / 10} VND</span>
              </div>
            </div>
          </div>
        </div>
      }
    </div>
  )
}

export default Cart