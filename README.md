# How to start Bank Backend

#### 1) Clone the repository
#### 2) Start the server
#### 3) Check the url for frontend in BankController class @CrossOrigin(origins = "http://localhost:3001"). If frontend is running on other port, you have to change it there.
#### 4) In Controller you have following operations to execute: create an account, deposit, withdraw, transfer and list all accounts. Use following url in postman to check the processing:
    http://localhost:8080/api/bank/create-account  (As a POST request)
    With raw body such as 
    {
    "name": "Alex",
    "balance": 0
    } 

    As a result you will receive:

    {
    "id": 903, (which is randomly generated)
    "name": "Alex",
    "balance": 0,
    "outgoingTransfers": []
    }
    
    To deposit money on account use:
    http://localhost:8080/api/bank/deposit?accountId=903&amount=500  (As a POST request)

    To withdraw money from account use:
    http://localhost:8080/api/bank/withdraw?accountId=903&amount=100 (As a POST request)

    To check all created accounts use: 
    http://localhost:8080/api/bank/listAccounts (As a GET request)
    You will receive following:

    {
    "list": [
        {
            "id": 903,
            "name": "Alex",
            "balance": 400,
            "outgoingTransfers": []
        },
        {
            "id": 728,
            "name": "Dima",
            "balance": 0,
            "outgoingTransfers": []
        }
    ]
    }


    And at the end use transfer using: 
    http://localhost:8080/api/bank/transfer?fromAccountId=903&toAccountId=728&amount=150 (As a POST request)
    and also check all accounts. At the end you receive:
    {
    "list": [
        {
            "id": 903,
            "name": "Alex",
            "balance": 250,
            "outgoingTransfers": [
                {
                    "id": "1",
                    "type": "transfer",
                    "date": "2024-11-13",
                    "amount": 150
                }
            ]
        },
        {
            "id": 728,
            "name": "Dima",
            "balance": 150,
            "outgoingTransfers": []
        }
    ]
    }

### If you have questions, feel free to ask them