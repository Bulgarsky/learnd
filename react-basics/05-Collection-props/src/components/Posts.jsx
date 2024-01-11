import Post from "./Post.jsx";

export default function Posts(props){
    //деструктуризация пропсов
    const {posts, cb, removePost} = props;

    return(
        <div>
            {
                posts.map(post =>(
                    <Post
                        //передаем пропсы ниже
                        key={post.id}
                        id={post.id}
                        name={post.name}
                        //передаем метод ниже
                        cb={cb}
                        removePost={removePost}
                    />
                ))
            }
        </div>
    )
}