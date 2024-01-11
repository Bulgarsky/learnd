const database = require('../postgres');
class PostController{
    async createPost(request, response){
        const {title, content, user_id} = request.body;
        console.log("request.body: ", title, content);
        /*
         {
         "title": "прорыв трубы отопление",
         "content": "Биз абразие! ЗА МИР ЗАЙКИ",
         "user_id": 1
         }
         */
        const newPost = await database
            .query('INSERT INTO posts(title, content, user_id) VALUES($1, $2, $3) RETURNING *', [title, content, user_id]);
        response.json(newPost.rows[0]);
        console.log("createPost: ", newPost.rows[0]);
    }

    async getPosts(request, response){
        const posts = await database
            .query('SELECT * FROM posts');
        response.json(posts.rows);
        console.log('getPosts:', posts.rows);
    }

    async getPostsByUser(request, response){
        /*
         http://localhost:8080/api/post?id=2
         */
        const id = request.query.id;
        const postsByUser = await database
            .query(`SELECT * FROM posts WHERE user_id=$1`, [id]);
        response.json(postsByUser.rows);
        console.log(postsByUser.rows)
    }

    async getPost(request, response){
        const id = request.params.id
        const post = await database
            .query(`SELECT * FROM posts WHERE id=$1`, [id]);
        response.json(post.rows[0]);
        console.log(post.rows[0]);
    }

    async updatePost(request, response){
        const id = request.params.id;
        const {title, content} = request.body;
        const post = await database.query('UPDATE posts set title=$1, content=$2 where id=$3 RETURNING *', [title, content, id]);
        response.json(post.rows[0]);
        console.log('updatePost: ', post.rows[0]);
    }

    async deletePost(request, response){
        const id = request.params.id;
        //http://localhost:8080/api/post/10
        const post = await database.query(`SELECT * FROM posts WHERE id=$1`, [id]);
        console.log("that post was deleted", post.rows[0]);
        const deleted = await database.query('DELETE FROM posts WHERE id=$1', [id]);
        response.json('post deleted Done');
    }
}

module.exports = new PostController();