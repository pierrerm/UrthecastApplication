
def fibonacci(n, n_2=0, n_1=1, current=2):
    """
    The n_th fibonacci number.

    Parameters
    ----------
    n : int
        The index of the fibonacci number to be computed.    
    n_2 : int, optional
        The value of the current-2 fibonacci number.    
    n_1 : int, optional
        The value of the current-1 fibonacci number.    
    current : int, optional
        The index of the current fibonacci number in the recursion.

    Returns
    -------
    int
        The value of the n_th fibonacci number.
    """
    if (n < 0):     # checks validity of input
        return 'Invalid input: please enter n >= 0'
    elif (n == 0):  # base case for recursion
        return 0
    elif (n == 1):  # base case for recursion
        return 1
    elif (current == n):    # stopping condition, n is reached
        return n_2 + n_1
    else:                   # recursive step, compute next fib number
        new_n_2 = n_1
        new_n_1 = n_2 + n_1
        return fibonacci(n, n_2=new_n_2, n_1=new_n_1, current=current+1)


print(fibonacci(19))
