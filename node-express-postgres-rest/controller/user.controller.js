const database = require('../postgres');

class UserController{
    //CRUD
    //create, read, update, delete
    async createUser(request, response){
        const {firstname, lastname} = request.body;
        console.log("request.body: ", firstname, lastname);

        const newPerson = await database
            .query(`INSERT INTO persons(firstname, lastname) VALUES ($1, $2) RETURNING *`, [firstname, lastname]);

        response.json(newPerson.rows[0]);
        console.log("createUser: ", newPerson.rows[0]);
    }

    async getUsers(request, response){
        const users = await database.query('SELECT * FROM persons');
        response.json(users.rows);
        console.log('getUsers:', users.rows);
    }

    async getUser(request, response){
        const id = request.params.id;
        const user = await database
            .query(`SELECT * from persons WHERE id=$1`, [id]);
        response.json(user.rows[0]);
        console.log('getUser: ', user.rows[0]);
    }

    async updateUser(request, response){
        const id = request.params.id;
        const {firstname, lastname} = request.body;
        const user = await database.query('UPDATE persons set firstname=$1, lastname=$2 where id=$3 RETURNING *', [firstname, lastname, id]);
        response.json(user.rows[0]);
        console.log('updateUser: ', user.rows[0]);
    }

    async deleteUser(request, response){
        const id = request.params.id;
        const user = await  database.query(`SELECT * from persons WHERE id=$1`, [id]);
        console.log('that user was deleted: ', user.rows[0]);
        const deleteUser = await database.query('DELETE FROM persons WHERE id=$1', [id]);
        response.json(`user deleted Done`);
    }

}

module.exports = new UserController();